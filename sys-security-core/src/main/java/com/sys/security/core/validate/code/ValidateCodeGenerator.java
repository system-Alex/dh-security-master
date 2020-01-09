/**
 * 
 */
package com.sys.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author alex
 *
 */
public interface ValidateCodeGenerator {

	ValidateCode generate(ServletWebRequest request);
	
}
