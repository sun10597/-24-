package org.example.securityexam.security1;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import org.springframework.core.annotation.Order;

import java.io.IOException;
@Order(2)
@WebFilter(urlPatterns = "/api")
public class CaramiFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("caramiFilter init() 실행전");
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        System.out.println("caramiFilter init() 실행전");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("caramiFilter init() 실행후");

    }

    @Override
    public void destroy() {
        System.out.println("caramiFilter destroy()");
    }
}
