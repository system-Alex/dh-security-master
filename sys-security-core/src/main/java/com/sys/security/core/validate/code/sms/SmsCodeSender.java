/**
 * 
 */
package com.sys.security.core.validate.code.sms;

/**
 * @author alex
 *
 */
public interface SmsCodeSender {
	
	void send(String mobile, String code);

}
