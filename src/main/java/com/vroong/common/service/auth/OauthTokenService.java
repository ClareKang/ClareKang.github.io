package com.vroong.common.service.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vroong.common.model.dto.auth.AuthTokenDto;
import com.vroong.lastmile.api.client.ApiException;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Arrays;

public abstract class OauthTokenService {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Setter
	protected String baseUrl;

	@Setter
	protected String authUrl;

	@Setter
	protected String userId;

	@Setter
	protected String password;

	private String token;

	private LocalDateTime tokenExpireDate;

	private Boolean isValidDate(LocalDateTime tokenExpireDate) {
		return tokenExpireDate.isAfter(LocalDateTime.now());
	}

	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.put("Authorization"	, Arrays.asList("Basic Y3VybDpwYXNzd29yZA=="));

		return headers;
	}

	private MultiValueMap<String, String> makeParameter(String userId, String password) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
		parameters.add("grant_type", "password");
		parameters.add("username", userId);
		parameters.add("password", password);

		return parameters;
	}

	public String getAuthToken() throws ApiException {
		try {
			if (token == null || tokenExpireDate == null || ! isValidDate(tokenExpireDate)) {
				RestTemplate restTemplate = new RestTemplate();

				HttpEntity<?> entity = new HttpEntity<>(makeParameter(userId, password), getHeaders());

				String response = restTemplate.postForObject(baseUrl + authUrl, entity, String.class);

				ObjectMapper mapper = new ObjectMapper();
				AuthTokenDto result = mapper.readValue(response, AuthTokenDto.class);

				int expiresIn = result.getExpiresIn();
				token = "bearer " + result.getAceessToken();
				tokenExpireDate = LocalDateTime.now().plusSeconds(expiresIn);

				logger.info("New access token received. Token is {}", token);
				logger.info("New access token received. Expires second is {}", expiresIn);
				logger.info("New access token received. Token will be expired at {}", tokenExpireDate);
			}

			return token;
		} catch (Exception e) {
			throw new ApiException(e);
		}
	}

}
