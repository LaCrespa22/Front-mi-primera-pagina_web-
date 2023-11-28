package com.udea.registrosUsuarios;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@SuppressWarnings("ALL")
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final LogoutHandler logoutHandler;

    public SecurityConfig(LogoutHandler logoutHandler) {
        this.logoutHandler = logoutHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        LogoutConfigurer<HttpSecurity> httpSecurityLogoutConfigurer = http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authRequest ->
                        authRequest
                                .requestMatchers("/").permitAll()
                                .requestMatchers("/css/**", "/js/**", "/vendor/**", "/fonts/**").permitAll()
                                .anyRequest().authenticated()
                )
                .oauth2Login()
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .addLogoutHandler(logoutHandler);
        return http.build();
    }
}
