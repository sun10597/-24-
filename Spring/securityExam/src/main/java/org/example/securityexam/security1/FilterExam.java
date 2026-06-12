package org.example.securityexam.security1;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class FilterExam implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filterExam init() 실행전");
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filterExam init()실행전");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("filterExam init()실행후");

    }

    @Override
    public void destroy() {
        System.out.println("filterExam destroy()");
    }
}
