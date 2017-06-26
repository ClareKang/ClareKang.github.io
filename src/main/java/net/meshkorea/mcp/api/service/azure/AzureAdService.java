package net.meshkorea.mcp.api.service.azure;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.meshkorea.mcp.api.domain.model.azure.AdUserSimple;
import net.meshkorea.mcp.api.domain.model.azure.ApiAccessTokenResponse;
import net.meshkorea.mcp.api.domain.model.azure.AdUserApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * Created by yjhan on 2017. 6. 24..
 */
@Service
public class AzureAdService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private static final String bearerTokenPrefix = "Bearer ";

    private static String accessToken;

    private static LocalDateTime tokenExpireDate;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${azure.ad.clientId}")
    private String clientId;

    @Value("${azure.ad.clientSecret}")
    private String clientSecret;

    @Value("${azure.ad.scope}")
    private String scope;

    @Value("${azure.ad.accessTokenUri}")
    private String accessTokenUri;

    @Value("${azure.ad.grantType}")
    private String grantType;

    @Value("${azure.ad.graph.api.users.url}")
    private String usersApiUrl;

    @Value("${azure.ad.graph.api.users.top}")
    private String usersSize;

    private void decodeToken(String jwtToken) {
        DecodedJWT jwt = JWT.decode(jwtToken);
        Date expiresAt = jwt.getExpiresAt();
        this.accessToken = jwtToken;
        this.tokenExpireDate = LocalDateTime.ofInstant(expiresAt.toInstant(), ZoneId.systemDefault());
    }

    private Boolean isValidDate(LocalDateTime tokenExpireDate) {
        if (tokenExpireDate != null) {
            return tokenExpireDate.isAfter(LocalDateTime.now());
        }
        return false;
    }

    private HttpHeaders getTokenHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        return httpHeaders;
    }

    private MultiValueMap<String, String> getTokenParamsForPost() {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("scope", scope);
        map.add("grant_type", grantType);
        map.add("client_id", clientId);
        map.add("client_secret", clientSecret);

        return map;
    }

    private HttpHeaders getUsersHeaders(String token) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", token);

        return httpHeaders;
    }

    private String buildUsersUrl() {
        return String.format("%s?$top=%s", usersApiUrl, usersSize);
    }

    private ApiAccessTokenResponse getToken() throws Exception {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<?> entity = new HttpEntity<>(getTokenParamsForPost(), getTokenHeaders());

        ResponseEntity<String> responseEntity = restTemplate.exchange(accessTokenUri, HttpMethod.POST, entity, String.class);

        return objectMapper.readValue(responseEntity.getBody(), ApiAccessTokenResponse.class);
    }

    private String getAccessToken() throws Exception {
        if (accessToken == null || tokenExpireDate == null || !isValidDate(tokenExpireDate)) {
            ApiAccessTokenResponse result = this.getToken();
            decodeToken(result.getAccessToken());
        }
        return bearerTokenPrefix + accessToken;
    }

    public List<AdUserSimple> getUsers() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> entity = new HttpEntity<>(getUsersHeaders(getAccessToken()));
        ResponseEntity<String> responseEntity = restTemplate.exchange(buildUsersUrl(), HttpMethod.GET, entity, String.class);

        AdUserApiResponse result = objectMapper.readValue(responseEntity.getBody(), AdUserApiResponse.class);
        List<AdUserSimple> users = result.getAdUserSimples();

        return users;
    }
}
