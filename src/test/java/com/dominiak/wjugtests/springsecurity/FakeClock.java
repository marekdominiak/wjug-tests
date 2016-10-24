package com.dominiak.wjugtests.springsecurity;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

public class FakeClock extends Clock {
    private Instant instant;
    private ZoneId zone;

    public FakeClock(Instant instant, ZoneId zone) {
        this.instant = instant;
        this.zone = zone;
    }


    @Override
    public long millis() {
        return instant.toEpochMilli();
    }

    @Override
    public ZoneId getZone() {
        return zone;
    }

    @Override
    public Clock withZone(ZoneId zone) {
        this.zone = zone;
        return this;
    }

    @Override
    public Instant instant() {
        return instant;
    }

    public void sleep(int millis) {
        instant = instant.plusMillis(millis);
    }
}
