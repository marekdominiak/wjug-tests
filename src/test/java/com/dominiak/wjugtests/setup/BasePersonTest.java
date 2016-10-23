package com.dominiak.wjugtests.setup;

import java.time.Instant;

public class BasePersonTest extends AbstractPersonTest {

    @org.testng.annotations.BeforeMethod
    public void setUpBase() {
        super.setupAbs();
    }

    protected Person newPerson() {
        return new Person(birthDate);
    }

    protected Instant maxInstant() {
        return Instant.parse("1996-12-03T10:15:30.00Z");
    }
}
