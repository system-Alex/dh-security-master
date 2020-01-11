/**
 * 
 */
package com.sys.security.core.support;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 简单响应的封装类
 * 
 * @author alex
 *
 */
@AllArgsConstructor
@Data
public class SimpleResponse {
	private Object content;
}
