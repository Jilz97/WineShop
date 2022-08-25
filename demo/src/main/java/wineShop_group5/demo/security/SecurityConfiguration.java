package wineShop_group5.demo.security;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	@Bean
	public DefaultSecurityFilterChain FilterChain(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests((authz)-> authz.antMatchers(HttpMethod.POST, "/api/**").hasAnyRole("USER","ADMIN")
												  .antMatchers(HttpMethod.GET, "/api/**").permitAll()
												  .antMatchers(HttpMethod.PUT,"/api/**").hasAnyRole("USER","ADMIN")
												  .antMatchers(HttpMethod.DELETE,"/api/**").hasRole("ADMIN"))
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.csrf()
			.disable();
		return http.build();
	}

	@Bean
	public InMemoryUserDetailsManager userDetails() {
		UserDetails user= User.withDefaultPasswordEncoder()
							  .username("user")
							  .password("password")
							  .roles("USER")
							  .build();
		return new InMemoryUserDetailsManager(user);
	}
	
	@Bean
	public InMemoryUserDetailsManager adminDetails() {
		UserDetails admin= User.withDefaultPasswordEncoder()
							  .username("admin")
							  .password("admin")
							  .roles("ADMIN")
							  .build();
		return new InMemoryUserDetailsManager(admin);
	}

}
