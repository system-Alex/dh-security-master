/**
 * 
 */
package com.sys.security.core.authentication;

import com.sys.security.core.properties.SysSecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author alex
 *
 */
@EnableWebSecurity
public class AbstractChannelSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	protected AuthenticationSuccessHandler sysAuthenticationSuccessHandler;
	
	@Autowired
	protected AuthenticationFailureHandler sysAuthenticationFailureHandler;
	
	protected void applyPasswordAuthenticationConfig(HttpSecurity http) throws Exception {
		http.formLogin()
			.loginPage(SysSecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
			.loginProcessingUrl(SysSecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
			.successHandler(sysAuthenticationSuccessHandler)
			.failureHandler(sysAuthenticationFailureHandler);
	}
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
}