package net.meshkorea.platform.core.web.servlet;

import com.google.common.collect.Iterables;
import com.google.common.collect.ObjectArrays;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ContentType;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Purpose of this class is to make getParameter() return post data AND also be able to get entire
 * body-string. In native implementation any of those two works, but not both together.
 */
public class MultiReadHttpServletRequest extends HttpServletRequestWrapper {
    public static final String UTF8 = "UTF-8";
    public static final Charset UTF8_CHARSET = Charset.forName(UTF8);
    private ByteArrayOutputStream cachedBytes;
    private Map<String, String[]> parameterMap;
    private static final String[] IP_HEADER_CANDIDATES = {
        "X-Forwarded-For",
        "Proxy-Client-IP",
        "WL-Proxy-Client-IP",
        "HTTP_X_FORWARDED_FOR",
        "HTTP_X_FORWARDED",
        "HTTP_X_CLUSTER_CLIENT_IP",
        "HTTP_CLIENT_IP",
        "HTTP_FORWARDED_FOR",
        "HTTP_FORWARDED",
        "HTTP_VIA",
        "REMOTE_ADDR"
    };

    public MultiReadHttpServletRequest(HttpServletRequest request) {
        super(request);
    }

    public static void toMap(Iterable<NameValuePair> inputParams, Map<String, String[]> toMap) {
        for (NameValuePair e : inputParams) {
            String key = e.getName();
            String value = e.getValue();
            if (toMap.containsKey(key)) {
                String[] newValue = ObjectArrays.concat(toMap.get(key), value);
                toMap.remove(key);
                toMap.put(key, newValue);
            } else {
                toMap.put(key, new String[]{value});
            }
        }
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        if (cachedBytes == null) cacheInputStream();
        return new CachedServletInputStream(cachedBytes.toByteArray());
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    @Override
    public String getParameter(String key) {
        String[] values = getParameterValues(key);
        return values != null && values.length > 0 ? values[0] : null;
    }

    @Override
    public String[] getParameterValues(String key) {
        return getParameterMap().get(key);
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        if (parameterMap == null) {
            Map<String, String[]> result = new LinkedHashMap<>();
            decode(getQueryString(), result);
            decode(getPostBodyAsString(), result);
            parameterMap = Collections.unmodifiableMap(result);
        }
        return parameterMap;
    }

    @Override
    public String getRemoteAddr() {
        String address = StringUtils.EMPTY;
        for (String header : IP_HEADER_CANDIDATES) {
            address = getHeader(header);
            if (StringUtils.isNotEmpty(address) && !"unknown".equalsIgnoreCase(address)) {
                break;
            }
        }

        if (StringUtils.isEmpty(address)) {
            address = super.getRemoteAddr();
        }

        return StringUtils.substringBefore(address, ",");
    }

    @Override
    public String toString() {
        String queryString = getQueryString();
        String query = queryString == null ? StringUtils.EMPTY : queryString;

        return "URL='" + getRequestURI() + (query.isEmpty() ? StringUtils.EMPTY : "?" + query)
            + "', body='" + getPostBodyAsString() + "'";
    }

    private String getPostBodyAsString() {
        try {
            if (cachedBytes == null) cacheInputStream();
            return cachedBytes.toString(UTF8);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void cacheInputStream() throws IOException {
        // Cache the inputStream in order to read it multiple times. For convenience, I use apache.commons IOUtils
        cachedBytes = new ByteArrayOutputStream();
        IOUtils.copy(super.getInputStream(), cachedBytes);
    }

    private void decode(String queryString, Map<String, String[]> result) {
        if (queryString != null)
            toMap(decodeParams(queryString), result);
    }

    private Iterable<NameValuePair> decodeParams(String body) {
        Iterable<NameValuePair> params = URLEncodedUtils.parse(body, UTF8_CHARSET);
        try {
            String cts = getContentType();
            if (cts != null) {
                ContentType ct = ContentType.parse(cts);
                if (ct.getMimeType().equals(ContentType.APPLICATION_FORM_URLENCODED.getMimeType())) {
                    List<NameValuePair> postParams = URLEncodedUtils.parse(IOUtils.toString(getReader()), UTF8_CHARSET);
                    params = Iterables.concat(params, postParams);
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        return params;
    }

}