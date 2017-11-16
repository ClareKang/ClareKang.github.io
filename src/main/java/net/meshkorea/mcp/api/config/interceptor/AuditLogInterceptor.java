package net.meshkorea.mcp.api.config.interceptor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.meshkorea.mcp.api.service.auth.OAuthUserService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
@DependsOn({
    "OAuthUserService"
})
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuditLogInterceptor extends HandlerInterceptorAdapter {

    private final OAuthUserService oAuthUserService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (request.getMethod().equals("POST")) {
            log.info("Method: [{}]", request.getMethod());
            log.info("RequestURI: [{}]", request.getRequestURI());
            log.info("RequestURL: [{}]", request.getRequestURL());
            log.info("RemoteAddr: [{}]", request.getRemoteAddr());
            log.info("RequestBody: [{}]", IOUtils.toString(request.getReader()));
            log.info("RequestUser: [{}]", oAuthUserService.getCurrentUser().getId());
        }

        return true;
    }
}
