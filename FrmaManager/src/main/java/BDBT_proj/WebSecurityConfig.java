package BDBT_proj;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	 @Bean
	  public UserDetailsService userDetailsService() {
	    return new UserDetailsServiceImp();
	  };
	  
	  @Bean
	  public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	  };
	  
	  @Override
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
	  }
	
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http.authorizeRequests()
	    .antMatchers("/", "/index","/images/**","/kontakt","/onas").permitAll()
	    .antMatchers("/admin/**").hasRole("ADMIN")
        .antMatchers("/kierowca/**").hasRole("KIEROWCA")
        .anyRequest().authenticated()
        .and()
     .formLogin()
        .defaultSuccessUrl("/default")
        .loginPage("/")
        .failureUrl("/")
        .and()
        .exceptionHandling().accessDeniedPage("/brakDostepu")
        .and()
        .logout()
        .logoutSuccessUrl("/")
        .clearAuthentication(true)
        .invalidateHttpSession(true)
	    .permitAll();
	  }
	  
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/css/**");
	    web.ignoring().antMatchers("/images/**");
	    web.ignoring().antMatchers("/static/**");
	    web.ignoring().antMatchers("/resources/**");
	}
}