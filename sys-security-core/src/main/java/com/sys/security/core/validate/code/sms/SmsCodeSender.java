/**
 * 
 */
package com.sys.security.core.validate.code.sms;

/**
 * @author alex
 * 短信发送接口 ----  不同供应商可能不同
 */
public interface SmsCodeSender {
	
	void send(String mobile, String code);

}
