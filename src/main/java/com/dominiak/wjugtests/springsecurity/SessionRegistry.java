package com.dominiak.wjugtests.springsecurity;
import java.util.List;

/**
 * Maintains a registry of <code>SessionInformation</code> instances.
 *
 * @author Ben Alex
 */
public interface SessionRegistry {
    //~ Methods ========================================================================================================

    /**
     * Obtains all the known principals in the <code>SessionRegistry</code>.
     *
     * @return each of the unique principals, which can then be presented to {@link #getAllSessions(Object, boolean)}.
     */
    List<Object> getAllPrincipals();

    /**
     * Obtains all the known sessions for the specified principal. Sessions that have been destroyed are not
     * returned. Sessions that have expired may be returned, depending on the passed argument.
     *
     * @param principal to locate sessions for (should never be <code>null</code>)
     * @param includeExpiredSessions if <code>true</code>, the returned sessions will also include those that have
     *        expired for the principal
     *
     * @return the matching sessions for this principal (should not return null).
     */
    List<SessionInformation> getAllSessions(Object principal, boolean includeExpiredSessions);

    /**
     * Obtains the session information for the specified <code>sessionId</code>. Even expired sessions are
     * returned (although destroyed sessions are never returned).
     *
     * @param sessionId to lookup (should never be <code>null</code>)
     *
     * @return the session information, or <code>null</code> if not found
     */
    SessionInformation getSessionInformation(String sessionId);

    /**
     * Updates the given <code>sessionId</code> so its last request time is equal to the present date and time.
     * Silently returns if the given <code>sessionId</code> cannot be found or the session is marked to expire.
     *
     * @param sessionId for which to update the date and time of the last request (should never be <code>null</code>)
     */
    void refreshLastRequest(String sessionId);

    /**
     * Registers a new session for the specified principal. The newly registered session will not be marked for
     * expiration.
     *
     * @param sessionId to associate with the principal (should never be <code>null</code>)
     * @param principal to associate with the session (should never be <code>null</code>)
     */
    void registerNewSession(String sessionId, Object principal);

    /**
     * Deletes all the session information being maintained for the specified <code>sessionId</code>. If the
     * <code>sessionId</code> is not found, the method gracefully returns.
     *
     * @param sessionId to delete information for (should never be <code>null</code>)
     */
    void removeSessionInformation(String sessionId);
}
