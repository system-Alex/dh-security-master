/**
 * 
 */
package com.sys.security.core.validate.code.sms;


import com.sys.security.core.properties.SysSecurityProperties;
import com.sys.security.core.validate.code.ValidateCode;
import com.sys.security.core.validate.code.ValidateCodeGenerator;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;


/**
 * @author alex
 * 注意验证码+ 超时时间可以进行配置
 */
@Component("smsValidateCodeGenerator")
@Data
public class SmsCodeGenerator implements ValidateCodeGenerator {

	@Autowired
	private SysSecurityProperties securityProperties;
	@Override
	public ValidateCode generate(ServletWebRequest request) {
		String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
		return new ValidateCode(code, securityProperties.getCode().getSms().getExpireIn());
	}

	
	

}
