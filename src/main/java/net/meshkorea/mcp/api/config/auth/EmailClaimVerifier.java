package net.meshkorea.mcp.api.config.auth;

import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.token.store.JwtClaimsSetVerifier;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.Map;

/**
 * Created by jihunlee on 2017. 8. 2..
 */
public class EmailClaimVerifier implements JwtClaimsSetVerifier {
    private static final String EMAIL_CLAIM = "email";
    private final String emailMatcher;

    /**
     *
     * @param emailMatcher regular expression to match with `email` claim
     */
    public EmailClaimVerifier(String emailMatcher) {
        Assert.notNull(emailMatcher, "emailMatcher cannot be null");
        this.emailMatcher = emailMatcher;
    }

    @Override
    public void verify(Map<String, Object> claims) throws InvalidTokenException {
        if (!CollectionUtils.isEmpty(claims) && claims.containsKey(EMAIL_CLAIM)) {
            String emailAddress = (String)claims.get(EMAIL_CLAIM);
            if(!emailAddress.matches(emailMatcher)) {
                throw new InvalidTokenException("Invalid Email (email) claim: " + emailAddress);
            }
        }
    }
}
