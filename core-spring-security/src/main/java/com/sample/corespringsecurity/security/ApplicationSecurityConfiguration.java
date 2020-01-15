//package com.sample.corespringsecurity.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
////-------------------------------------------------------------
//// Configuration Class for Web Security
////-------------------------------------------------------------
//@Configuration
//@EnableWebSecurity
//public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    //-------------------------------------------------------------
//    // configure http security
//    //-------------------------------------------------------------
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/api/user/message").hasAnyRole("USER", "ADMIN")
//                .antMatchers("/api/admin/message").hasRole("ADMIN")
//                .anyRequest().authenticated()
//                .and().httpBasic();
//    }
//
//
//    //-------------------------------------------------------------
//    // first approach for creation user InMemory
//    //-------------------------------------------------------------
//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        List<UserDetails> userDetails = new ArrayList<>();
//        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//        userDetails.add(userBuilder.username("jon").password("1234").roles("USER").build());
//        userDetails.add(userBuilder.username("alireza").password("1234").roles("ADMIN", "USER").build());
//        return new InMemoryUserDetailsManager(userDetails);
//    }
//
//    //-------------------------------------------------------------
//    // High Order
//    // second approach for configuring a user InMemory is configure(AuthenticationManagerBuilder auth)
//    //-------------------------------------------------------------
////    @Override
////    public void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.inMemoryAuthentication()
////                .withUser("sample")
////                .password("1234")
////                .roles("USER")
////                .and()
////                .passwordEncoder(NoOpPasswordEncoder.getInstance());
////    }
//}
