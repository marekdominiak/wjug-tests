package com.dominiak.wjugtests.springsecurity;


import java.io.Serializable;
import java.time.Clock;
import java.util.Date;

public class SessionInformation implements Serializable {


    //~ Instance fields ================================================================================================

    private Date lastRequest;
    private final Object principal;
    private final String sessionId;
    private boolean expired = false;
    private Clock clock;

    //~ Constructors ===================================================================================================

    public SessionInformation(Object principal, String sessionId, Date lastRequest, Clock clock) {
        Assert.notNull(principal, "Principal required");
        Assert.hasText(sessionId, "SessionId required");
        Assert.notNull(lastRequest, "LastRequest required");
        this.principal = principal;
        this.sessionId = sessionId;
        this.lastRequest = lastRequest;
        this.clock = clock;
    }

    //~ Methods ========================================================================================================

    public void expireNow() {
        this.expired = true;
    }

    public Date getLastRequest() {
        return lastRequest;
    }

    public Object getPrincipal() {
        return principal;
    }

    public String getSessionId() {
        return sessionId;
    }

    public boolean isExpired() {
        return expired;
    }

    /**
     * Refreshes the internal lastRequest to the current date and time.
     */
    public void refreshLastRequest() {
        this.lastRequest = Date.from(clock.instant());
    }
}
