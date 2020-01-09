/**
 * 
 */
package com.sys.security.core.properties;

import lombok.Data;

/**
 * @author alex
 *
 */
@Data
public class SocialProperties {
	
	private String filterProcessesUrl = "/auth";

	private QQProperties qq = new QQProperties();
	
	private WeixinProperties weixin = new WeixinProperties();

}
