/**
 * 
 */
package com.sys.security.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author alex
 *
 */
@Component
@ConfigurationProperties(prefix = "sys.security")
@Data
public class SysSecurityProperties {
	
	private BrowserProperties browser = new BrowserProperties();
	
	private ValidateCodeProperties code = new ValidateCodeProperties();
	
	private SocialProperties social = new SocialProperties();

}

