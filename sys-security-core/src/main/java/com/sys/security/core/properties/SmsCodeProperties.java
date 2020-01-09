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
public class SmsCodeProperties {
	
	private int length = 6;
	private int expireIn = 60;
	private String url;

}
