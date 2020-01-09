/**
 * 
 */
package com.sys.security.browser;


import com.sys.security.browser.logout.SysLogoutSuccessHandler;
import com.sys.security.browser.session.SysExpiredSessionStrategy;
import com.sys.security.browser.session.SysInvalidSessionStrategy;
import com.sys.security.core.properties.SysSecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;


/**
 * @author alex
 *
 */
@Configuration
public class BrowserSecurityBeanConfig {

	@Autowired
	private SysSecurityProperties securityProperties;
	
	@Bean
	@ConditionalOnMissingBean(InvalidSessionStrategy.class)
	public InvalidSessionStrategy invalidSessionStrategy(){
		return new SysInvalidSessionStrategy(securityProperties.getBrowser().getSession().getSessionInvalidUrl());
	}
	
	@Bean
	@ConditionalOnMissingBean(SessionInformationExpiredStrategy.class)
	public SessionInformationExpiredStrategy sessionInformationExpiredStrategy(){
		return new SysExpiredSessionStrategy(securityProperties.getBrowser().getSession().getSessionInvalidUrl());
	}
	@Bean
	@ConditionalOnMissingBean(LogoutSuccessHandler.class)
	public LogoutSuccessHandler logoutSuccessHandler(){
		return new SysLogoutSuccessHandler(securityProperties.getBrowser().getSignOutSuccessUrl());
	}
	
}
