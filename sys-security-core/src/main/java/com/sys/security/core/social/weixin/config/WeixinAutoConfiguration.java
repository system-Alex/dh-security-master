/**
 * 
 */
package com.sys.security.core.social.weixin.config;


import com.sys.security.core.properties.SysSecurityProperties;
import com.sys.security.core.properties.WeixinProperties;
import com.sys.security.core.social.SysConnectView;
import com.sys.security.core.social.qq.config.SocialAutoConfigurerAdapter;
import com.sys.security.core.social.weixin.connect.WeixinConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.web.servlet.View;


/**
 * 微信登录配置
 * 
 * @author alex
 *
 */
@Configuration
@ConditionalOnProperty(prefix = "sys.security.social.weixin", name = "app-id")
public class WeixinAutoConfiguration extends SocialAutoConfigurerAdapter {

	@Autowired
	private SysSecurityProperties securityProperties;

	@Override
	protected ConnectionFactory<?> createConnectionFactory() {
		WeixinProperties weixinConfig = securityProperties.getSocial().getWeixin();
		return new WeixinConnectionFactory(weixinConfig.getProviderId(), weixinConfig.getAppId(),
				weixinConfig.getAppSecret());
	}
	
	@Bean({"connect/weixinConnect", "connect/weixinConnected"})
	@ConditionalOnMissingBean(name = "weixinConnectedView")
	public View weixinConnectedView() {
		return new SysConnectView();
	}
	
}
