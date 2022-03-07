package com.hasibur.CareerFootsteps.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

        return daoAuthenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/", "/signup", "/login/**", "/process_signup/**", "/access_denied", "/logout_warning").permitAll();

        http.authorizeRequests().antMatchers("/css/**", "/js/**", "/img/**").permitAll();

        http.authorizeRequests().antMatchers("/admin").hasAuthority("ADMIN")
                .and().formLogin().loginPage("/login");

        http.authorizeRequests().antMatchers("/**").hasAnyAuthority("ADMIN", "USER")
                .and().formLogin().loginPage("/login");

        http.authorizeRequests().antMatchers("/logout").hasAnyAuthority("ADMIN", "USER")
                .and().formLogin().loginPage("/login");

        http.authorizeRequests().antMatchers("/admin").hasAuthority("ADMIN")
                .and().formLogin().loginPage("/login");

        http.exceptionHandling().accessDeniedPage("/access_denied");
    }
}
