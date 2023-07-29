package com.edem.LibraryManagementSystem.Config;

import org.apache.catalina.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("doctor").password("{noop}1234").roles(UserRole.DOCTOR.name())
                .and().withUser("adbul").password("{noop}123").roles(UserRole.STUDENT.name())
                .and().withUser("edem").password("{noop}123").roles(UserRole.ADMIN.name())
                .and().withUser("enchil").password("{noop}123").roles(UserRole.STUDENT.name())
                .and().withUser("prince").password("{noop}123").roles(UserRole.STUDENT.name())
                .and().withUser("robert").password("{noop}123").roles(UserRole.STUDENT.name());
    }


}
