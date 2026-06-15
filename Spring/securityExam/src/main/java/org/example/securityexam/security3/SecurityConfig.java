package org.example.securityexam.security3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception{
        httpSecurity.authorizeHttpRequests(auth -> auth
                .requestMatchers("/shop/**").permitAll()
                .requestMatchers("user/**").hasAnyRole("USER", "ADMIN")
                .requestMatchers("admin/**").hasAnyRole("SUPERUSER")
                .anyRequest().authenticated()
        )
                .formLogin(Customizer.withDefaults())
                .logout( logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/hello")
                );

        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
        UserDetails admin = User.withUsername("qwer")
                .password(passwordEncoder.encode("1234"))
                .roles("ADMIN")
                .build();

        UserDetails user1 = User.withUsername("user1")
                .password(passwordEncoder.encode("1234"))
                .roles("USER")
                .build();

        UserDetails user2 = User.withUsername("user2")
                .password(passwordEncoder.encode("1234"))
                .roles("USER")
                .build();

        UserDetails user3 = User.withUsername("user3")
                .password(passwordEncoder.encode("1234"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin, user1, user2, user3);
    }

//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return;
//    }
}
