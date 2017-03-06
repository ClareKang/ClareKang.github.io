package com.vroong.lastmile.api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vroong.lastmile.api.client.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by sychae on 2016. 6. 30..
 */
@Service
public class LastmileTokenService {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Value(value = "${vroong.lastmile.api.baseUrl}")
	private String lastmileBaseUrl;

	@Value(value = "${vroong.lastmile.api.authUrl}")
	private String lastmileAuthUrl;

	@Value(value = "${vroong.lastmile.api.userId}")
	private String lastmileUserId;

	@Value(value = "${vroong.lastmile.api.passwd}")
	private String lastmilePasswd;

	private String lastmileToken;

	private LocalDateTime lastmileTokenExpireDate;

	public String getAuthorizationToken() throws ApiException {
		try {
			LocalDateTime now = LocalDateTime.now();
			if(lastmileToken == null || lastmileTokenExpireDate == null || lastmileTokenExpireDate.isAfter(now)) {
				RestTemplate restTemplate = new RestTemplate();

				MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
				parameters.add("grant_type", "password");
				parameters.add("username", lastmileUserId);
				parameters.add("password", lastmilePasswd);

				HttpHeaders headers = new HttpHeaders();
				headers.put("Authorization"	, Arrays.asList("Basic Y3VybDpwYXNzd29yZA=="));
				headers.put("Content-Type"	, Arrays.asList("multipart/form-data"		));

				HttpEntity<?> entity = new HttpEntity<>(parameters, headers);

				String response = restTemplate.postForObject(lastmileBaseUrl + lastmileAuthUrl, entity, String.class);

				ObjectMapper mapper = new ObjectMapper();
				HashMap result = mapper.readValue(response, HashMap.class);

				int expiresIn = (Integer) result.get("expires_in");
				lastmileToken = "bearer " + result.get("access_token");

				now = now.plusSeconds(expiresIn);
				lastmileTokenExpireDate = now;

				logger.info("New access token received. Token is {}", lastmileToken);
				logger.info("New access token received. Expires second is {}", expiresIn);

				logger.info("New access token received. Token will be expired at {}", lastmileTokenExpireDate);
			}

			return lastmileToken;
		} catch (Exception e) {
			throw new ApiException(e);
		}
	}

}
