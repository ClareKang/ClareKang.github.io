package net.meshkorea.mcp.api.config.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;

import java.util.Arrays;

/**
 * Created by jihunlee on 2017. 5. 17..
 */
// @Configuration
// @EnableOAuth2Client
public class AzureAdOpenIdConnectConfig {
    @Value("${azureAd.clientId}")
    private String clientId;

    @Value("${azureAd.clientSecret}")
    private String clientSecret;

    @Value("${azureAd.accessTokenUri}")
    private String accessTokenUri;

    @Value("${azureAd.userAuthorizationUri}")
    private String userAuthorizationUri;

    @Value("${azureAd.redirectUri}")
    private String redirectUri;

    @Bean
    public OAuth2ProtectedResourceDetails azureAdOpenId() {
        AuthorizationCodeResourceDetails details = new AuthorizationCodeResourceDetails();
        details.setClientId(clientId);
        details.setClientSecret(clientSecret);
        details.setAccessTokenUri(accessTokenUri);
        details.setUserAuthorizationUri(userAuthorizationUri);
        details.setScope(Arrays.asList("openid"));
        details.setPreEstablishedRedirectUri(redirectUri);
        details.setClientAuthenticationScheme(AuthenticationScheme.form);
        details.setUseCurrentUri(false);
        return details;
    }

    @Bean
    public OAuth2RestTemplate azureAdOpenIdTemplate(OAuth2ClientContext clientContext) {
        return new OAuth2RestTemplate(azureAdOpenId(), clientContext);
    }
}
