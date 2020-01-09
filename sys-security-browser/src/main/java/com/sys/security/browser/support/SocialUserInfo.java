/**
 * 
 */
package com.sys.security.browser.support;

import lombok.Data;

/**
 * @author alex
 *
 */
@Data
public class SocialUserInfo {
	
	private String providerId;
	
	private String providerUserId;
	
	private String nickname;
	
	private String headimg;
}
