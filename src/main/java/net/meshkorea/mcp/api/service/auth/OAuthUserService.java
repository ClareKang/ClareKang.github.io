package net.meshkorea.mcp.api.service.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import net.meshkorea.mcp.api.domain.model.auth.OAuthUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Service;

/**
 * Created by yjhan on 2017. 7. 9..
 */
@Service
public class OAuthUserService {

    public OAuthUser getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();

        return getOAuthUserByToken(details.getTokenValue());
    }

    private OAuthUser getOAuthUserByToken(String jwtToken) {
        DecodedJWT jwt = JWT.decode(jwtToken);
        OAuthUser user = new OAuthUser();
        user.setEmail(jwt.getClaim("email").asString());
        user.setName(jwt.getClaim("name").asString());
        return user;
    }
}
