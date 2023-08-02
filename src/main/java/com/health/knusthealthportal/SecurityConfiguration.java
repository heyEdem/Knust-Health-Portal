//package com.health.knusthealthportal;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//
//@Configuration
//public class SecurityConfiguration {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//        return http
//                .authorizeHttpRequests(authorizeHttpRequests-> authorizeHttpRequests
//                        .requestMatchers(HttpMethod.GET,"/home").permitAll()
//                        .requestMatchers(HttpMethod.GET,"/appointmentForm").permitAll()
//                        .requestMatchers(HttpMethod.POST,"/appointmentForm").permitAll()
//                        .requestMatchers(HttpMethod.GET,"/all-appointments").hasAuthority("ADMIN")
//                        .requestMatchers(HttpMethod.GET, "/editAppointment").hasAuthority("ADMIN")
//                        .requestMatchers(HttpMethod.POST, "/editAppointment").hasAuthority("ADMIN")
//                        .anyRequest().authenticated())
//                .build();
//    }
//}
