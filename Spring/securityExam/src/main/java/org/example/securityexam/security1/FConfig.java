package org.example.securityexam.security1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FConfig {
    @Bean
    public FilterRegistrationBean<CaramiFilter> caramiFilter() {
        FilterRegistrationBean<CaramiFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new CaramiFilter());
        registrationBean.addUrlPatterns("/api/*");
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<UserFilter> UserFilter() {
        FilterRegistrationBean<UserFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new UserFilter());
        registrationBean.addUrlPatterns("/users/*");
        registrationBean.setOrder(3);
        return registrationBean;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class User {
        private  String name;
    }

    public static class UserContext {
        private static final ThreadLocal<User> userThreadLocal = ThreadLocal.withInitial(()->null);

        public static void setUser(User user){
            userThreadLocal.set(user);
        }

        public static User getUser(){
            return userThreadLocal.get();
        }

        public static void clear(){
            userThreadLocal.remove();
        }
    }
}
