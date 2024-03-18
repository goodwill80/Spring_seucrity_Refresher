package com.security.Lesson.on.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers("/account", "/balance", "/loan", "/card", "/user").authenticated()
                                .requestMatchers("/notice", "/contact", "/register").permitAll()
//                        .anyRequest().authenticated()
//                        .anyRequest().denyAll()
//                        .anyRequest().permitAll()
                )
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    // Instantiating passwordEncoder to user Bcrypt Encoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Method 1 - to create users
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("12345")
//                .authorities("admin")
//                .build();
//
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("12345")
//                .authorities("read")
//                .build();
//        return new InMemoryUserDetailsManager(admin, user);
//    }

    // Method 2 - to create users
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//                UserDetails admin = User.withUsername("admin")
//                .password("12345")
//                .authorities("admin")
//                .build();
//
//                UserDetails user = User.withUsername("user")
//                .password("12345")
//                .authorities("read")
//                .build();
//
//                return new InMemoryUserDetailsManager(admin, user);
//    }

//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }

    // This will treat password as a plain text in storage - non encoder
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }

}
