package com.hotel.booking.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true, securedEnabled = true)
public class SecurityConfig 
  extends WebSecurityConfigurerAdapter {
	 // Securing the urls and allowing role-based access to these urls.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
        .antMatchers("/hotel/getCustomers").hasRole("ADMIN")
        .antMatchers("/hotel/checkRoomWithCriteria").hasRole("USER")
        .and().csrf().disable();
        http.headers().frameOptions().disable();
    }
 
    // In-memory authentication to authenticate the user i.e. the user credentials are stored in the memory.
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("guest").password("{noop}guest1234").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("{noop}admin1234").roles("ADMIN");
    }
}