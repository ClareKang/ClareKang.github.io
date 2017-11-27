package net.meshkorea.mcp.api.service.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import net.meshkorea.mcp.api.domain.model.auth.OAuthUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Service;

@Service
public class OAuthUserService {

    public OAuthUser getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return new OAuthUser();
        }
        Object object = authentication.getDetails();
        if (object == null || !(object instanceof OAuth2AuthenticationDetails)) {
            return new OAuthUser();
        }
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) object;

        return getOAuthUserByToken(details.getTokenValue());
    }

    private OAuthUser getOAuthUserByToken(String jwtToken) {
        OAuthUser user = new OAuthUser();
        if (StringUtils.isEmpty(jwtToken)) {
            return user;
        }
        DecodedJWT jwt = JWT.decode(jwtToken);
        user.setEmail(jwt.getClaim("email").asString());
        user.setName(jwt.getClaim("name").asString());
        return user;
    }
}
