/**
 * 
 */
package com.sys.security.app.authentication;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sys.security.core.properties.LoginResponseType;
import com.sys.security.core.properties.SysSecurityProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author alex
 *
 */
@Component("sysAuthenticationSuccessHandler")
@Slf4j
public class SysAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private SysSecurityProperties securityProperties;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		logger.info("登录成功");

		if (LoginResponseType.JSON.equals(securityProperties.getBrowser().getLoginType())) {
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(objectMapper.writeValueAsString(authentication));
		} else {
			super.onAuthenticationSuccess(request, response, authentication);
		}

	}

}
