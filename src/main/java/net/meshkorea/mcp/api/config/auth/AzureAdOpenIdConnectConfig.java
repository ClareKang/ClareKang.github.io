package net.meshkorea.mcp.api.config.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

import java.util.Arrays;

/**
 * Created by jihunlee on 2017. 5. 17..
 */
//@Configuration
//@EnableOAuth2Client
public class AzureAdOpenIdConnectConfig {

    @Value("${azure.ad.clientId}")
    private String clientId;

    @Value("${azure.ad.clientSecret}")
    private String clientSecret;

    @Value("${azure.ad.resourceUri}")
    private String resourceUri;

    @Value("${azure.ad.accessTokenUri}")
    private String accessTokenUri;

    @Value("${azure.ad.grantType}")
    private String grantType;

    @Bean
    public OAuth2ProtectedResourceDetails azureAdOpenId() {
        AuthorizationCodeResourceDetails details = new AuthorizationCodeResourceDetails();
        details.setClientId(clientId);
        details.setClientSecret(clientSecret);
        details.setAccessTokenUri(accessTokenUri);
        details.setGrantType(grantType);
        details.setScope(Arrays.asList("openid"));
        // details.setUseCurrentUri(false);
        return details;
    }

    @Bean
    public OAuth2RestTemplate azureAdOpenIdTemplate(OAuth2ClientContext clientContext) {
        return new OAuth2RestTemplate(azureAdOpenId(), clientContext);
    }

}
