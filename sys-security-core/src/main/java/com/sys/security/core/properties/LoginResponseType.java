/**
 * 
 */
package com.sys.security.core.properties;

/**
 * @author alex
 *处理成功和处理失败可以有不同的方式,这里做个简单处理,要么都为REDIRECT,要么都为JSON
 */
public enum LoginResponseType {
	
	/**
	 * 跳转
	 */
	REDIRECT,
	
	/**
	 * 返回json
	 */
	JSON

}
