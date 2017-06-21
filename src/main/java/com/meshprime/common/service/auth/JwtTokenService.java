package com.meshprime.common.service.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.meshprime.api.client.ApiException;
import com.meshprime.api.client.api.AuthApi;
import com.meshprime.api.client.model.AuthenticateRequest;
import com.meshprime.api.client.model.AuthenticateResult;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by reverof on 2017. 3. 16..
 */
public abstract class JwtTokenService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Setter
    private String userId;

    @Setter
    private String password;

    private String jwtToken;

    private String token;

    private LocalDateTime tokenExpireDate;

    public abstract AuthApi getAuthApi();

    private Boolean isValidDate(LocalDateTime tokenExpireDate) {
        if (tokenExpireDate != null) {
            return tokenExpireDate.isAfter(LocalDateTime.now());
        }
        return false;
    }

    private void decodeToken(String jwtToken) {
        DecodedJWT jwt = JWT.decode(jwtToken);
        Date expiresAt = jwt.getExpiresAt();
        this.token = "bearer " + jwtToken;
        this.tokenExpireDate = LocalDateTime.ofInstant(expiresAt.toInstant(), ZoneId.systemDefault());
    }

    private AuthenticateRequest makeAuthenticateRequest(String userId, String password) {
        AuthenticateRequest authenticateRequest = new AuthenticateRequest();
        authenticateRequest.setEmail(userId);
        authenticateRequest.setPassword(password);
        return authenticateRequest;
    }

    public String getAuthToken() throws ApiException {

        try {
            if (token == null || tokenExpireDate == null || !isValidDate(tokenExpireDate)) {

                AuthApi authApi = getAuthApi();
                AuthenticateResult authenticateResult = authApi.login(makeAuthenticateRequest(userId, password));

                jwtToken = authenticateResult.getAccessToken();
                decodeToken(jwtToken);

                logger.info("New access token received. JWT token is [{}]", jwtToken);
                logger.info("New access token received. Token will be expired at [{}]", tokenExpireDate);
            }

            return token;
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
