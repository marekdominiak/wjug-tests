package com.dominiak.wjugtests.setup;

import java.time.Instant;
import java.time.LocalDate;

public class BasePersonTest extends AbstractPersonTest {

    @org.testng.annotations.BeforeMethod
    public void setUpBase() {
        super.setupAbs();
    }

    protected Person newPerson() {
        return new Person(birthDate);
    }

    protected LocalDate maxInstant() {
        return LocalDate.parse("1996-12-03");
    }
}
