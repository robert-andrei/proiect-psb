package com.banking.software.design.gymsubscription.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class CustomSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // This is the code you usually have to configure your authentication manager.
        // This configuration will be used by authenticationManagerBean() below.

        http.authorizeRequests().antMatchers("/").permitAll();
        http.csrf().disable();
    }

//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        // ALTHOUGH THIS SEEMS LIKE USELESS CODE,
//        // IT'S REQUIRED TO PREVENT SPRING BOOT AUTO-CONFIGURATION
//        return super.authenticationManagerBean();
//    }
}
