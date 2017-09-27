package com.dominiak.wjugtests.setup;

import org.testng.annotations.BeforeMethod;

import java.time.Instant;
import java.time.LocalDate;

public abstract class AbstractPersonTest {
    protected LocalDate birthDate;

    @BeforeMethod
    public void setupAbs() {
        birthDate = LocalDate.parse("1992-12-03");
    }
}
