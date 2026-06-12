package org.example.securityexam.security2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, DefaultAuthenticationEventPublisher authenticationEventPublisher)throws Exception{
//        httpSecurity.authorizeHttpRequests(auth -> auth
//                .anyRequest().authenticated()
//        )
//                .formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults())
//                .csrf(Customizer.withDefaults());
//

        httpSecurity.authorizeHttpRequests(auth -> auth
                //허용된 URL
                .requestMatchers( "/login", "/test/*", "/api/*").permitAll()
                //나머지 제외
                .anyRequest().authenticated()
                )
                //로그인 처리
                .formLogin(formLogin -> formLogin
                        .loginProcessingUrl("/loginProc")
                        .loginPage("/login")
                        .usernameParameter("name")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/", true)
                )
                //error처리
                .exceptionHandling(exception -> exception
                        .accessDeniedPage("/error")
                )
                .logout(logout -> logout
                        .logoutUrl("/logoutProc")
                        .logoutSuccessUrl("/login")
                        .invalidateHttpSession(true)          // 1. 서버 쪽 세션을 완전히 삭제 (기록 말소)
                        .deleteCookies("JSESSIONID")
                );


        return httpSecurity.build();
    }
}
