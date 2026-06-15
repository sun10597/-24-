package org.example.securityexam.security2;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Slf4j
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
                .requestMatchers( "/login", "/test/*", "/api/*", "/error", "/loginFail").permitAll()
                //나머지 제외
                .anyRequest().authenticated()
                )
//                .csrf(csrf -> csrf.disable())
                //로그인 처리
                .formLogin(formLogin -> formLogin
                        .loginProcessingUrl("/loginProc")
                        .loginPage("/login")
                        .usernameParameter("name")
                        .passwordParameter("password")
//                        .defaultSuccessUrl("/", true)

                        .successHandler((request, response, authentication) -> {
                            log.info("로그인성공 : " + authentication.getName());
                            response.sendRedirect("/");
                        })
                                .failureHandler((request, response, exception) -> {
                                    log.info("로그인 실패 : " + exception.getMessage());
                                    response.sendRedirect("/loginFail");
                                })
                )
                .rememberMe(rememberMe -> rememberMe
                        .tokenValiditySeconds(60)
                )
                //error 처리
                .exceptionHandling(exception -> exception
                        .accessDeniedPage("/error")
                )
                //로그아웃 처리
                .logout(logout -> logout
                        .logoutUrl("/logoutProc")
                        .logoutSuccessUrl("/login")

                        .addLogoutHandler((request, response, authentication) -> {
                            log.info("로그아웃 세션 쿠키삭제");
                        })
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                );



        return httpSecurity.build();
    }
}
