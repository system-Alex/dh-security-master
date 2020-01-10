/**
 * 
 */
package com.sys.security.core.properties;

import lombok.Data;

/**
 * @author alex
 *
 */
@Data
public class BrowserProperties {
	
	private SessionProperties session = new SessionProperties();
	
	private String signUpUrl = "/sys-signUp.html";
	private String signOutSuccessUrl="/sys-logout.html";
	
	private String signInPage = SysSecurityConstants.DEFAULT_SIGN_IN_PAGE_URL;
	
	private LoginResponseType loginType = LoginResponseType.JSON;
	
	private int rememberMeSeconds = 3600;

}
