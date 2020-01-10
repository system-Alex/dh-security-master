package com.sys.security.app;

import com.sys.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.sys.security.core.properties.SysSecurityConstants;
import com.sys.security.core.properties.SysSecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * 资源服务器
 */
@Configuration
@EnableResourceServer
public class SysResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    protected AuthenticationSuccessHandler sysAuthenticationSuccessHandler;
    @Autowired
    protected AuthenticationFailureHandler sysAuthenticationFailureHandler;
    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;
    @Autowired
    private SpringSocialConfigurer sysSocialSecurityConfig;
    @Autowired
    private SysSecurityProperties securityProperties;
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage(SysSecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
                .loginProcessingUrl(SysSecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                .successHandler(sysAuthenticationSuccessHandler)
                .failureHandler(sysAuthenticationFailureHandler);

        http//.apply(validateCodeSecurityConfig)
              //  .and()
                .apply(smsCodeAuthenticationSecurityConfig)
                .and()
                .apply(sysSocialSecurityConfig)
                .and()
                .authorizeRequests()
                .antMatchers(
                        SysSecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                        SysSecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
                        securityProperties.getBrowser().getSignInPage(),
                        SysSecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX+"/*",
                        securityProperties.getBrowser().getSignUpUrl(),
                        securityProperties.getBrowser().getSession().getSessionInvalidUrl()+".json",
                        securityProperties.getBrowser().getSession().getSessionInvalidUrl()+".html",
                        securityProperties.getBrowser().getSignOutSuccessUrl(),
                        "/user/regist")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();

    }

}
