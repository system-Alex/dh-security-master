/**
 * 
 */
package com.sys.security.browser.session;

import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import java.io.IOException;

/**
 * @author alex
 *
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
