package com.health.knusthealthportal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
            http
                    .authorizeHttpRequests().requestMatchers("/home","/appointmentForm","/all-appointments","/static/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin().loginPage("/login").permitAll()
                    //No need to add a LoginController.
                    // Needed because if you don't put this, when you call the POST to login you will be redirected to the login.html page.
                    .defaultSuccessUrl("/home", true)
                    .failureUrl("/login").permitAll()
                    .and()
                    .logout().permitAll().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    return http.build();
    }
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user1 = User.withUsername("edem")
                .password("{noop}12")
                .roles(Roles.ADMIN.name())
                .build();
        UserDetails user2 = User.withUsername("abdul")
                .password("{noop}123")
                .roles(Roles.DOCTOR.name())
                .build();
        UserDetails user3 = User.withUsername("prince")
                .password("{noop}1234")
                .roles(Roles.STUDENT.name())
                .build();
        UserDetails user4 = User.withUsername("robert")
                .password("{noop}12345")
                .roles(Roles.STUDENT.name())
                .build();
        UserDetails user5 = User.withUsername("edwin")
                .password("{noop}123456")
                .roles(Roles.STUDENT.name())
                .build();
        return new InMemoryUserDetailsManager(user1, user2, user3, user4, user5);

    }
}
