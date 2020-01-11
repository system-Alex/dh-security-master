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


    /**
     * /@ConditionalOnMissingBean注解后面可以是name也可以是Type（XXX.class）
     *如果为name表示当spring容器里没有该名字的类时，被@ConditionalOnMissingBean注解的bean才可以注册到spring容器
     * 如果为type表示当spring容器里没有该类型的类时，被@ConditionalOnMissingBean注解的bean才可以注册到spring容器
     *假如业务觉得我们提供的代码生成器太low，想换一个高大上的，比较好的做法不是随意改我们提供的默认代码
     * 而是自己实现一套逻辑覆盖掉我们的逻辑------》实际开发中这叫“增量开发”
     * @return
     */
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
