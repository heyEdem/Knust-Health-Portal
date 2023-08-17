package com.health.knusthealthportal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
            http
                    .csrf().disable()
                    .authorizeHttpRequests()
                    .requestMatchers("/all-appointments").hasRole(Roles.ADMIN.name())
                    .requestMatchers("/home","/appointmentForm","/static/**").permitAll()
                    .requestMatchers("/login").permitAll()
                    .anyRequest()
                    .authenticated()
                    .and()
                    .formLogin().loginPage("/login").permitAll()
                    .defaultSuccessUrl("/home", true)
                    .failureUrl("/login?error=true").permitAll()
                    .and()
                    .logout().permitAll().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user1 = User.withUsername("Edem")
                .password(passwordEncoder().encode("12"))
                .roles(Roles.ADMIN.name())
                .build();
        UserDetails user2 = User.withUsername("Abdul")
                .password(passwordEncoder().encode("123"))
                .roles(Roles.DOCTOR.name())
                .build();
        UserDetails user3 = User.withUsername("Prince")
                .password(passwordEncoder().encode("1234"))
                .roles(Roles.STUDENT.name())
                .build();
        UserDetails user4 = User.withUsername("Robert")
                .password(passwordEncoder().encode("12345"))
                .roles(Roles.STUDENT.name())
                .build();
        UserDetails user5 = User.withUsername("Edwin")
                .password(passwordEncoder().encode("123456"))
                .roles(Roles.STUDENT.name())
                .build();
        return new InMemoryUserDetailsManager(user1, user2, user3, user4, user5);

    }
    @Bean
public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
