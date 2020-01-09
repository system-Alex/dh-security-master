/**
 * 
 */
package com.sys.security.core.validate.code;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * @author alex
 *
 */
@Data
@AllArgsConstructor
public class ValidateCode implements Serializable {
	private static final long serialVersionUID = 162900044932073435L;
	private String code;
	
	private LocalDateTime expireTime;
	
	public ValidateCode(String code, int expireIn){
		this.code = code;
		this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
	}
	public boolean isExpired() {
		return LocalDateTime.now().isAfter(expireTime);
	}

}
