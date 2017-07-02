package net.meshkorea.mcp.api.utils;

import org.springframework.web.util.UriComponents;
import org.thymeleaf.util.StringUtils;

import java.net.URL;
import java.util.Arrays;

/**
 * Created by yjhan on 2017. 6. 28..
 */
public class UrlUtils {

    private static String getSiteDomainParts(String url) {
        if (StringUtils.isEmpty(url) || StringUtils.contains(url, "localhost")) {
            return url;
        }
        String[] urlParts = url.split("\\.");
        if (urlParts.length > 2) {
            return String.join(".", Arrays.copyOfRange(urlParts, urlParts.length - 2, urlParts.length));
        } else {
            return String.join(".", urlParts);
        }
    }

    public static String getSiteDomain(URL url) {
        return getSiteDomainParts(url.getHost());
    }

    public static String getSiteDomain(UriComponents uriComponents) {
        return getSiteDomainParts(uriComponents.getHost());
    }

    public static String getSiteDomain(String hostname) {
        return getSiteDomainParts(hostname);
    }
}
