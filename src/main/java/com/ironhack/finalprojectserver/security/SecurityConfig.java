package com.ironhack.finalprojectserver.security;

import com.ironhack.finalprojectserver.filter.CustomAuthenticationFilter;
import com.ironhack.finalprojectserver.filter.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
        customAuthenticationFilter.setFilterProcessesUrl("/api/auth/login");
        http.csrf().disable();
        http.cors();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http.authorizeRequests().antMatchers("/api/auth/login/**").permitAll();
        http.authorizeRequests().antMatchers("/api/auth/signup").permitAll();
        http.authorizeRequests().antMatchers("/api/auth/signup/withRole").permitAll();
        http.authorizeRequests().antMatchers("/", "/csrf", "/v2/api-docs", "/swagger-resources/configuration/ui", "/configuration/ui", "/swagger-resources", "/swagger-resources/configuration/security", "/configuration/security", "/swagger-ui.html", "/webjars/**").permitAll();

        http.authorizeRequests().antMatchers(GET, "/api/projects/**").
                hasAnyAuthority("ROLE_TEACHER", "ROLE_STUDENT");
        http.authorizeRequests().antMatchers(GET, "/api/calculators/**").
                hasAnyAuthority("ROLE_TEACHER", "ROLE_STUDENT");
        http.authorizeRequests().antMatchers(POST, "/api/projects/**").
                hasAnyAuthority("ROLE_TEACHER","ROLE_ADMIN");
        http.authorizeRequests().antMatchers(POST, "/api/calculators/**").
                hasAnyAuthority("ROLE_TEACHER","ROLE_ADMIN");
        http.authorizeRequests().antMatchers(PUT, "/api/projects/**").
                hasAnyAuthority("ROLE_TEACHER","ROLE_ADMIN");
        http.authorizeRequests().antMatchers(PUT, "/api/calculators/**").
                hasAnyAuthority("ROLE_TEACHER","ROLE_ADMIN");
        http.authorizeRequests().antMatchers(DELETE, "/api/projects/**").
                hasAnyAuthority("ROLE_TEACHER","ROLE_ADMIN");
        http.authorizeRequests().antMatchers(DELETE, "/api/calculators/**").
                hasAnyAuthority("ROLE_TEACHER","ROLE_ADMIN");

        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
