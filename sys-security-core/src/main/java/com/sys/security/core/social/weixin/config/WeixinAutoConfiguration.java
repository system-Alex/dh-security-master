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
 *将微信连接工厂注入到spring容器
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
    /***
     * connect/weixinConnected 绑定成功的视图
     * connect/weixinConnect 解绑的视图
     *
     * 两个视图可以写在一起，通过判断Model对象里有没有Connection对象来确定究竟是解绑还是绑定
     */
	@Bean({"connect/weixinConnect", "connect/weixinConnected"})
    //下面的注解的意思是当程序里有名字为weixinConnectedView的bean
    // 默认的weixinConnectedView这个bean不会生效，也可以写一个更好的bean来覆盖掉我的
	@ConditionalOnMissingBean(name = "weixinConnectedView")
	public View weixinConnectedView() {
		return new SysConnectView();
	}
	
}
