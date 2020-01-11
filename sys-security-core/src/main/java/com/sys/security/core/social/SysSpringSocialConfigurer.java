/**
 *
 */
package com.sys.security.core.social;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @author alex
 *继承springsocialSocial为我们提供的SocialAuthenticationFilter的配置类SpringSocialConfigurer
 *并重写其后置处理方法，让其默认拦截包含我们配置字符串的请求
 */
@Data
public class SysSpringSocialConfigurer extends SpringSocialConfigurer {

    private String filterProcessesUrl;
    /**
     *注入成功处理器处理器 -- 为null时走spring-security默认的，否则走传递过来的，这里也就是指可以发送token的
     */
    private SocialAuthenticationFilterPostProcessor socialAuthenticationFilterPostProcessor;

    public SysSpringSocialConfigurer(String filterProcessesUrl) {
        this.filterProcessesUrl = filterProcessesUrl;
    }
    /**
     * T 其实就是指的SocialAuthenticationFilter类型
     *
     * @param object
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    protected <T> T postProcess(T object) {
        //在父类处理完SocialAuthenticationFilter之后的基础上，将其默认拦截url改成我们配置的值
        SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
        filter.setFilterProcessesUrl(filterProcessesUrl);
        //如果配置了后置成功处理器，就将其传入
        if (socialAuthenticationFilterPostProcessor != null) {
            socialAuthenticationFilterPostProcessor.process(filter);
        }
        return (T) filter;
    }


}
