package com.sk.api.client.poi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sk.api.client.poi.model.dto.PoiResultDto;
import org.apache.http.Header;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicHeader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;

/**
 * Created by reverof on 2017-05-09.
 */
@Service
public class PoiService {

    @Value("${sk.openApi.poi.appKey}")
    private String appKey;

    @Value("${sk.openApi.poi.url}")
    private String url;

    @Value("${sk.openApi.poi.version}")
    private String version;

    @Value("${sk.openApi.poi.resCoordType}")
    private String resCoordType;

    @Value("${sk.openApi.poi.searchType}")
    private String searchType;

    @Value("${sk.openApi.poi.searchtypCd}")
    private String searchtypCd;

    @Value("${sk.openApi.poi.count}")
    private String count;

    private String page = "1";

    private URI makeUri(String searchKeyword) throws Exception {
        URIBuilder builder = new URIBuilder(url);
        builder.addParameter("version", version);
        builder.addParameter("page", page);
        builder.addParameter("count", count);
        builder.addParameter("resCoordType", resCoordType);
        builder.addParameter("searchType", searchType);
        builder.addParameter("searchtypCd", searchtypCd);
        builder.addParameter("searchKeyword", searchKeyword);

        return builder.build();
    }

    private Header getHeader() {
        return new BasicHeader("appKey", appKey);
    }

    public PoiResultDto getAddress(String searchKeyword) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(Request.Get(makeUri(searchKeyword))
                .setHeader(getHeader())
                .execute()
                .returnContent()
                .asString(), PoiResultDto.class);
    }

}
