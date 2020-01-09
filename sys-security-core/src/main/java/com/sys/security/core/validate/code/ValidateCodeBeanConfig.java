/**
 * 
 */
package com.sys.security.core.validate.code;


import com.sys.security.core.properties.SysSecurityProperties;
import com.sys.security.core.validate.code.image.ImageCodeGenerator;
import com.sys.security.core.validate.code.sms.DefaultSmsCodeSender;
import com.sys.security.core.validate.code.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author alex
 *
 */
@Configuration
public class ValidateCodeBeanConfig {
	
	@Autowired
	private SysSecurityProperties securityProperties;
	
	@Bean
	@ConditionalOnMissingBean(name = "imageValidateCodeGenerator")
	public ValidateCodeGenerator imageValidateCodeGenerator() {
		ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
		codeGenerator.setSecurityProperties(securityProperties);
		return codeGenerator;
	}
	
	@Bean
	@ConditionalOnMissingBean(SmsCodeSender.class)
	public SmsCodeSender smsCodeSender() {
		return new DefaultSmsCodeSender();
	}

}
