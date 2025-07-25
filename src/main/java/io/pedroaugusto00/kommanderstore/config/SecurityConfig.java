package io.pedroaugusto00.kommanderstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
        http
        .csrf(csrf -> csrf.disable()) 
        .authorizeHttpRequests(auth -> auth
            .requestMatchers(HttpMethod.GET, "/produtos/**").permitAll()
            .anyRequest().authenticated() 
        )
        .httpBasic();
		return http.build();
	} 
	
	@Bean
	public UserDetailsService userDetailsService() {
	    UserDetails user = User
	        .withUsername("admin")
	        .password("admin")
	        .roles("GERENTE")
	        .build();
	    
	    UserDetails user2 = User.withUsername("Pedro")
	    		.password("123")
	    		.roles("GERENTE")
	    		.build();
	    
	    UserDetails user3 = User.withUsername("Joao")
	    		.password("123")
	    		.roles("OPERADOR")
	    		.build();
	    
	    return new InMemoryUserDetailsManager(user, user2, user3);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return NoOpPasswordEncoder.getInstance(); // NÃO usar em produção!
	}
}
