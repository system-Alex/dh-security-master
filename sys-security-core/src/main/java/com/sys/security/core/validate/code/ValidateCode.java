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
 *存放到redis里的对象必须是序列化的，所以这里要实现Serializable接口
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
