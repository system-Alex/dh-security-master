/**
 * 
 */
package com.sys.security.browser.session;

import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import java.io.IOException;

/**
 * @author alex
 *如果设置的session并发策略为一个账户第二次登陆会将第一次给踢下来
 *则第一次登陆的用户再访问我们的项目时会进入到该类
 *event里封装了request、response信息
 */
public class SysExpiredSessionStrategy extends AbstractSessionStrategy implements SessionInformationExpiredStrategy {

	public SysExpiredSessionStrategy(String invalidSessionUrl) {
		super(invalidSessionUrl);
	}

	@Override
	public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException {
		onSessionInvalid(event.getRequest(), event.getResponse());
	}

	@Override
	protected boolean isConcurrency() {
		return true;
	}

}
