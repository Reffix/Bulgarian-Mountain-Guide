package com.mountain.project.config;

import com.mountain.project.enums.UserRole;
import com.mountain.project.security.JwtAuthenticationExceptionHandlingFilter;
import com.mountain.project.security.JwtTokenProcessingFilter;
import com.mountain.project.security.UnauthorizedRequestHandler;
import com.mountain.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;

import static org.springframework.http.HttpMethod.*;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UnauthorizedRequestHandler unauthorizedRequestHandler;

    @Autowired
    private JwtTokenProcessingFilter jwtTokenProcessingFilter;

    @Autowired
    private JwtAuthenticationExceptionHandlingFilter jwtAuthenticationExceptionHandlingFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
                .antMatchers(POST, "/users/register/**", "/users/login/**").permitAll()
                .antMatchers(GET, "/**").permitAll()
                .antMatchers(POST, "/**").hasRole(UserRole.ADMIN.toString())
                .antMatchers(PUT, "/**").hasRole(UserRole.ADMIN.toString())
                .antMatchers(DELETE, "/**").hasRole(UserRole.ADMIN.toString())
                .antMatchers("/**").permitAll()
                .and().exceptionHandling().authenticationEntryPoint(unauthorizedRequestHandler);

        http.addFilterBefore(jwtTokenProcessingFilter, UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(jwtAuthenticationExceptionHandlingFilter, LogoutFilter.class);
    }

    @Bean
    public UserDetailsService getUserDetailsService(UserService userService) {
        return userService::getUserByUsername;
    }

    @Bean
    public AuthenticationManager getAuthenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
