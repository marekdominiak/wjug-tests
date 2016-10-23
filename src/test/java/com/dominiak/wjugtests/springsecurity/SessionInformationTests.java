package com.dominiak.wjugtests.springsecurity;


import com.dominiak.wjugtests.springsecurity.SessionInformation;
import org.testng.annotations.Test;

import java.time.Clock;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;


public class SessionInformationTests {

	// ~ Methods
	// ========================================================================================================
	@Test
	public void testObjectSlow() throws Exception {
		Object principal = "Some principal object";
		String sessionId = "1234567890";
		Date currentDate = new Date();

		SessionInformation info = new SessionInformation(principal, sessionId,
				currentDate, Clock.systemDefaultZone());
		assertThat(info.getPrincipal()).isEqualTo(principal);
		assertThat(info.getSessionId()).isEqualTo(sessionId);
		assertThat(info.getLastRequest()).isEqualTo(currentDate);

		Thread.sleep(10);

		info.refreshLastRequest();

		assertThat(info.getLastRequest().after(currentDate)).isTrue();
	}

//	@Test
//	public void testObjectBetter() throws Exception {
//		Object principal = "Some principal object";
//		String sessionId = "1234567890";
//		Date currentDate = new Date();
//		FakeClock clock = new FakeClock(currentDate.toInstant(), ZoneId.systemDefault());
//
//		SessionInformation info = new SessionInformation(principal, sessionId,
//				currentDate, clock);
//		assertThat(info.getPrincipal()).isEqualTo(principal);
//		assertThat(info.getSessionId()).isEqualTo(sessionId);
//		assertThat(info.getLastRequest()).isEqualTo(currentDate);
//
//		clock.sleep(10);
//
//		info.refreshLastRequest();
//
//		assertThat(info.getLastRequest().after(currentDate)).isTrue();
//	}

}
