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
import org.springframework.stereotype.Component;

/**
 * @author alex
 *
 */
@Component
public class AbstractChannelSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	protected AuthenticationSuccessHandler sysAuthenticationSuccessHandler;
	
	@Autowired
	protected AuthenticationFailureHandler sysAuthenticationFailureHandler;
	
	protected void applyPasswordAuthenticationConfig(HttpSecurity http) throws Exception {
		http.formLogin()
			.loginPage(SysSecurityConstants.DEFAULT_UN_AUTHENTICATION_URL)
			.loginProcessingUrl(SysSecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_FORM)
			.successHandler(sysAuthenticationSuccessHandler)
			.failureHandler(sysAuthenticationFailureHandler);
	}

	
}
