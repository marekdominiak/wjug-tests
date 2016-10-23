package com.dominiak.wjugtests.setup;

import org.testng.annotations.BeforeMethod;

import java.time.Instant;

public abstract class AbstractPersonTest {
    protected Instant birthDate;

    @BeforeMethod
    public void setupAbs() {
        birthDate = Instant.parse("2007-12-03T10:15:30.00Z");
    }
}
