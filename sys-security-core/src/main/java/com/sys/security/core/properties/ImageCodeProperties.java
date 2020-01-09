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
public class ImageCodeProperties extends SmsCodeProperties {
	
	public ImageCodeProperties() {
		setLength(4);
	}
	 
	private int width = 67;
	private int height = 23;
}
