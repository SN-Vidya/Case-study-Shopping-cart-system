package com.shoppingcartsystem.profileservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableConfigurationProperties
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	MongoUserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests().anyRequest().authenticated()
		.and().httpBasic()
		.and().sessionManagement().disable();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder builder) throws Exception{
		builder.userDetailsService(userDetailsService);
	}
}
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		auth.inMemoryAuthentication()
//		     .withUser("Vidya").password("snv@1209").roles("USER");
//	
//	}
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		http.httpBasic()
//		.and().authorizeRequests()
//		      .antMatchers("/user/**").hasRole("USER")
//		      //.permitAll()
//		      .and().csrf().disable().headers().frameOptions().disable();
//	}
//
//	@Bean
//	public PasswordEncoder getPasswordEncoder()
//	{
//		return NoOpPasswordEncoder.getInstance();
//	}
//}




