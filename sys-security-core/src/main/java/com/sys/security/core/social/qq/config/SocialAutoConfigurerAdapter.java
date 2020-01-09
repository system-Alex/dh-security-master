package com.sys.security.core.social.qq.config;

import org.springframework.core.env.Environment;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactory;

/**
 * @Author alex
 * @Date 2020/1/4 11:49
 */
public abstract class SocialAutoConfigurerAdapter extends SocialConfigurerAdapter {
    public SocialAutoConfigurerAdapter() {
    }
    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer configurer, Environment environment) {
        configurer.addConnectionFactory(this.createConnectionFactory());
    }
    protected abstract ConnectionFactory<?> createConnectionFactory();
}
