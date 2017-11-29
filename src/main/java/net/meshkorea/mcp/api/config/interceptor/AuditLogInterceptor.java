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

        String space = " ";

        if ("POST".equals(request.getMethod())
            || "PUT".equals(request.getMethod())
            || "DELETE".equals(request.getMethod())
            || "PATCH".equals(request.getMethod())) {
            String logString = String.format("[%s]", oAuthUserService.getCurrentUser().getEmail())
                + space + String.format("[%s]", request.getMethod())
                + space + String.format("[%s]", request.getRemoteAddr())
                + space + String.format("[%s]", request.getRequestURL())
                + space + String.format("[%s]", IOUtils.toString(request.getReader()));
            log.info(logString);
        }

        return true;
    }
}
