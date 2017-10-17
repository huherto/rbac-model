package io.github.huherto.rbac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import io.github.huherto.rbac.services.MyUserDetailsService;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        	.csrf()
        		.disable()
            .authorizeRequests()
                .antMatchers("/index.html","/sb-admin-2/**","/vendor/**").permitAll()
                .anyRequest().authenticated()
//            	.anyRequest().permitAll()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    @Autowired
    MyUserDetailsService userDetailsService;
    
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        // authProvider.setPasswordEncoder(new BCryptPasswordEncoder(11));
        return authProvider;
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        /*
        auth
            .inMemoryAuthentication()
                .withUser("hh").password("hh").roles("USER");
        */
        
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        
        // auth.authenticationProvider(authenticationProvider());
    }
    
    @Bean 
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);        
    }
}
