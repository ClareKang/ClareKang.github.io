package net.meshkorea.mcp.api.config.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.jwk.JwkTokenStore;

/**
 * Created by jihunlee on 2017. 5. 23..
 */
@EnableResourceServer
@EnableWebSecurity
@Configuration
public class OAuth2ResourceServerConfiguration implements ResourceServerConfigurer {

    @Value("${google.openidConnect.jwksUri}")
    private String jwksUri;

    @Value("${google.openidConnect.resourceId}")
    private String resourceId;

    @Bean
    public TokenStore tokenStore() {
        return new JwkTokenStore(jwksUri);
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore())
            .resourceId(resourceId);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers(HttpMethod.OPTIONS, "/**").permitAll() //allow CORS option calls
            .antMatchers("/v1/common/**").permitAll()
            .antMatchers("/v1/cert/mobile/**").permitAll()
            .antMatchers("/v1/mms/send").permitAll()
            .antMatchers("/v2/api-docs").permitAll()
            .antMatchers("/swagger-ui.html").permitAll()
            .anyRequest().authenticated();
    }
}
