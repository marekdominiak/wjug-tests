package com.dominiak.wjugtests.springsecurity;

import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SessionRegistryImplTests {
	private SessionRegistryImpl sessionRegistry;


	// ~ Methods
	// ========================================================================================================

	@BeforeMethod
	public void setUp() throws Exception {
		sessionRegistry = new SessionRegistryImpl();
	}

	@Test
	public void testMultiplePrincipals() throws Exception {
		Object principal1 = "principal_1";
		Object principal2 = "principal_2";
		String sessionId1 = "1234567890";
		String sessionId2 = "9876543210";
		String sessionId3 = "5432109876";

		sessionRegistry.registerNewSession(sessionId1, principal1);
		sessionRegistry.registerNewSession(sessionId2, principal1);
		sessionRegistry.registerNewSession(sessionId3, principal2);

		assertThat(sessionRegistry.getAllPrincipals()).hasSize(2);
		assertThat(sessionRegistry.getAllPrincipals().contains(principal1)).isTrue();
		assertThat(sessionRegistry.getAllPrincipals().contains(principal2)).isTrue();
	}

	@Test//(invocationCount = 1000)
	public void testSessionInformationLifecycle() throws Exception {
		Object principal = "Some principal object";
		String sessionId = "1234567890";
		// Register new Session
		sessionRegistry.registerNewSession(sessionId, principal);

		// Retrieve existing session by session ID
		Date currentDateTime = sessionRegistry.getSessionInformation(sessionId)
				.getLastRequest();
		assertThat(sessionRegistry.getSessionInformation(sessionId).getPrincipal()).isEqualTo(principal);
		assertThat(sessionRegistry.getSessionInformation(sessionId).getSessionId()).isEqualTo(sessionId);
		assertThat(sessionRegistry.getSessionInformation(sessionId).getLastRequest()).isNotNull();

		// Retrieve existing session by principal
		assertThat(sessionRegistry.getAllSessions(principal, false)).hasSize(1);

		// Sleep to ensure SessionRegistryImpl will update time

		Thread.sleep(1000);

		// Update request upperThreshold/time
		sessionRegistry.refreshLastRequest(sessionId);

		Date retrieved = sessionRegistry.getSessionInformation(sessionId)
				.getLastRequest();
		assertThat(retrieved.after(currentDateTime)).isTrue();

		// Check it retrieves correctly when looked up via principal
		assertThat(sessionRegistry.getAllSessions(principal, false).get(0).getLastRequest()).isCloseTo(retrieved, 2000L);

		// Clear session information
		sessionRegistry.removeSessionInformation(sessionId);

		// Check attempts to retrieve cleared session return null
		assertThat(sessionRegistry.getSessionInformation(sessionId)).isNull();
		assertThat(sessionRegistry.getAllSessions(principal, false)).isEmpty();
	}

	@Test//(invocationCount = 1000)
	public void testSessionInformationLifecycle_Faster() throws Exception {
		FakeClock clock = new FakeClock(Instant.now(), ZoneId.systemDefault());
		sessionRegistry = new SessionRegistryImpl(clock);
		Object principal = "Some principal object";
		String sessionId = "1234567890";
		// Register new Session
		sessionRegistry.registerNewSession(sessionId, principal);

		// Retrieve existing session by session ID
		Date currentDateTime = sessionRegistry.getSessionInformation(sessionId)
				.getLastRequest();
		assertThat(sessionRegistry.getSessionInformation(sessionId).getPrincipal()).isEqualTo(principal);
		assertThat(sessionRegistry.getSessionInformation(sessionId).getSessionId()).isEqualTo(sessionId);
		assertThat(sessionRegistry.getSessionInformation(sessionId).getLastRequest()).isNotNull();

		// Retrieve existing session by principal
		assertThat(sessionRegistry.getAllSessions(principal, false)).hasSize(1);

		// Sleep to ensure SessionRegistryImpl will update time

		clock.sleep(1000);

		// Update request upperThreshold/time
		sessionRegistry.refreshLastRequest(sessionId);

		Date retrieved = sessionRegistry.getSessionInformation(sessionId)
				.getLastRequest();
		assertThat(retrieved.after(currentDateTime)).isTrue();

		// Check it retrieves correctly when looked up via principal
		assertThat(sessionRegistry.getAllSessions(principal, false).get(0).getLastRequest()).isCloseTo(retrieved, 2000L);

		// Clear session information
		sessionRegistry.removeSessionInformation(sessionId);

		// Check attempts to retrieve cleared session return null
		assertThat(sessionRegistry.getSessionInformation(sessionId)).isNull();
		assertThat(sessionRegistry.getAllSessions(principal, false)).isEmpty();
	}

	@Test
	public void testTwoSessionsOnePrincipalExpiring() throws Exception {
		Object principal = "Some principal object";
		String sessionId1 = "1234567890";
		String sessionId2 = "9876543210";

		sessionRegistry.registerNewSession(sessionId1, principal);
		List<SessionInformation> sessions = sessionRegistry.getAllSessions(principal,
				false);
		Assertions.assertThat(sessions).hasSize(1);
		assertThat(contains(sessionId1, principal)).isTrue();

		sessionRegistry.registerNewSession(sessionId2, principal);
		sessions = sessionRegistry.getAllSessions(principal, false);
		Assertions.assertThat(sessions).hasSize(2);
		assertThat(contains(sessionId2, principal)).isTrue();

		// Expire one session
		SessionInformation session = sessionRegistry.getSessionInformation(sessionId2);
		session.expireNow();

		// Check retrieval still correct
		assertThat(sessionRegistry.getSessionInformation(sessionId2).isExpired()).isTrue();
		assertThat(sessionRegistry.getSessionInformation(sessionId1).isExpired()).isFalse();
	}

	@Test
	public void testTwoSessionsOnePrincipalHandling() throws Exception {
		Object principal = "Some principal object";
		String sessionId1 = "1234567890";
		String sessionId2 = "9876543210";

		sessionRegistry.registerNewSession(sessionId1, principal);
		List<SessionInformation> sessions = sessionRegistry.getAllSessions(principal,
				false);
		Assertions.assertThat(sessions).hasSize(1);
		assertThat(contains(sessionId1, principal)).isTrue();

		sessionRegistry.registerNewSession(sessionId2, principal);
		sessions = sessionRegistry.getAllSessions(principal, false);
		Assertions.assertThat(sessions).hasSize(2);
		assertThat(contains(sessionId2, principal)).isTrue();

		sessionRegistry.removeSessionInformation(sessionId1);
		sessions = sessionRegistry.getAllSessions(principal, false);
		Assertions.assertThat(sessions).hasSize(1);
		assertThat(contains(sessionId2, principal)).isTrue();

		sessionRegistry.removeSessionInformation(sessionId2);
		assertThat(sessionRegistry.getSessionInformation(sessionId2)).isNull();
		assertThat(sessionRegistry.getAllSessions(principal, false)).isEmpty();
	}

	private boolean contains(String sessionId, Object principal) {
		List<SessionInformation> info = sessionRegistry.getAllSessions(principal, false);

		for (int i = 0; i < info.size(); i++) {
			if (sessionId.equals(info.get(i).getSessionId())) {
				return true;
			}
		}

		return false;
	}
}
