/**
 * 
 */
package com.sys.security.core.social.weixin.api;

/**
 * 微信API调用接口
 * 
 * @author alex
 *QQ是获取完accessToken，然后拿着accessToken去换openId
 * 微信是在获取accessToken的同时也会获取到openId
 */
public interface Weixin {
	WeixinUserInfo getUserInfo(String openId);
}
