package net.meshkorea.mcp.api.config.auth;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by sungjae.hong on 2017. 2. 28..
 */
public class SpringAuthorizationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException{
        //여기서 권한체크
        System.out.println("************AFTER*************");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getName());
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpSession session = httpServletRequest.getSession(false);
        session.setAttribute("name", authentication.getName());
        request.setAttribute("auth", authentication.getAuthorities());
        System.out.println(session);

        filterChain.doFilter(request, response);
        System.out.println("************AFTER DONE*************");
    }

    @Override
    public void destroy() {

    }
}
