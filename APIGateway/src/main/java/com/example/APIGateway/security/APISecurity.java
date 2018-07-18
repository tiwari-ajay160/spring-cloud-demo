package com.example.APIGateway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class APISecurity extends WebSecurityConfigurerAdapter {

	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserDetailsService uservalidateSerice;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
        .authorizeRequests().antMatchers("/emp-register/register/getAllUsers","/emp-register/register/saveNewUser").hasRole("admin")
        .antMatchers("/emp-register/login/getAllUsers","/emp-register/login/saveLogin").hasRole("admin")
        .antMatchers("/emp-register/**").hasAnyRole("admin","user")
        .antMatchers("/emp-service/saveHours","/emp-service/allEmpAvg").hasRole("admin")
        .antMatchers("/emp-service/**").hasAnyRole("admin","user")
        .and().formLogin().permitAll()
        .and().logout().permitAll();

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("admin@1")).roles("admin").and().
//		withUser("user1").password(passwordEncoder.encode("user@1")).roles("user");	
		auth.userDetailsService(uservalidateSerice).passwordEncoder(passwordEncoder);
	}
	
	
	
	

	
}
