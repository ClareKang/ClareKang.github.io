package net.meshkorea.mcp.api.config.auth;

import net.meshkorea.mcp.api.service.auth.OAuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

/**
 * Created by yjhan on 2017. 7. 10..
 */
@Component
@DependsOn({
    "OAuthUserService"
})
public class UserAuditorAware implements AuditorAware<String> {

    @Autowired
    private OAuthUserService oAuthUserService;

    @Override
    public String getCurrentAuditor() {
        return oAuthUserService.getCurrentUser().getId();
    }
}
