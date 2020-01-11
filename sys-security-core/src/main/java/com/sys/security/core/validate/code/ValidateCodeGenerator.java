/**
 * 
 */
package com.sys.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author alex
 *以后还会有其他验证码生成逻辑，故将其统一定义出来
 */
public interface ValidateCodeGenerator {

	ValidateCode generate(ServletWebRequest request);
	
}
