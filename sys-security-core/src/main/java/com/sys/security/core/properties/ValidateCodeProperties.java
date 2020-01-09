/**
 * 
 */
package com.sys.security.core.properties;

import lombok.Data;

/**
 * @author ALEX
 *
 */
@Data
public class ValidateCodeProperties {
	
	private ImageCodeProperties image = new ImageCodeProperties();
	
	private SmsCodeProperties sms = new SmsCodeProperties();

	
}
