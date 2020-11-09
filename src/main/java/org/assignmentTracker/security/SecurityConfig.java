package org.assignmentTracker.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String USER_ROLE = "USER";
    private static final String ADMIN_ROLE = "ADMIN";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Byron")
                .password(encoder().encode("password"))
                .roles(ADMIN_ROLE, USER_ROLE)
                .and()
                .withUser("Robyn")
                .password(encoder().encode("wordpass"))
                .roles(USER_ROLE);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/assignmenttrackerdb/**/create", "/assignmenttrackerdb/**/delete/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET, "/assignmenttrackerdb/**/read/**", "/assignmenttrackerdb/**/all").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.POST, "/Lecture/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.DELETE, "/Lecture/delete/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET, "/Lecture/read/**", "/Lecture/all/").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.POST, "/Member/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.DELETE, "/Member/delete/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET, "/Member/read/**", "/Member/all/").hasRole(USER_ROLE)
                .and()
                .csrf().disable()
                .formLogin().disable();
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
