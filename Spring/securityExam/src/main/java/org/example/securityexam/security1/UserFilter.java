package org.example.securityexam.security1;

import jakarta.servlet.*;

import java.io.IOException;

public class UserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            System.out.println("UserFilter::: Thread Name : " + Thread.currentThread().getName());

            FConfig.User user = new FConfig.User("kim");
            FConfig.UserContext.setUser(user);

            filterChain.doFilter(servletRequest, servletResponse);
            System.out.println("UserFilter: doFilter 실행후:: Thread Name : " + Thread.currentThread().getName());
        }finally {
            FConfig.UserContext.clear();
        }
    }

    private FConfig.User extractUserFromRequest(ServletRequest servletRequest){
        String name = servletRequest.getParameter("name");
        return new FConfig.User(name);
    }
}
