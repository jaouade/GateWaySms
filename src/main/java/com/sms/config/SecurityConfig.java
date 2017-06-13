package com.sms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/***
 *
 * @author kel
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsService userDetailsService;



    @Autowired
    private Redirect redirect;

    @Override
    public void configure(WebSecurity web) throws Exception {
        String[] unsecuredResources = {"client/**", "/ville/**", "/signup", "/username","/activate", "sub/**", "index/!#/signup"};
        web.ignoring().antMatchers(unsecuredResources);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/resources/**").permitAll().anyRequest().authenticated()
                .antMatchers("/admin/**").access("hasRole('Role_Admin')").and().formLogin().loginPage("/login")
                .permitAll().usernameParameter("username").passwordParameter("password").failureUrl("/login?error=1")
                .successHandler(redirect).loginProcessingUrl("/login").and().rememberMe()
                .rememberMeParameter("rememberMe").rememberMeCookieName("user").and().csrf().disable().logout()
                .logoutSuccessUrl("/login?logout=1").permitAll();
    }

    public Redirect getRedirect() {
        return redirect;
    }

    public void setRedirect(Redirect redirect) {
        this.redirect = redirect;
    }

}
