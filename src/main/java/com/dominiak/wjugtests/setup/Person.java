package com.dominiak.wjugtests.setup;

import java.time.Instant;


public class Person {
    private Instant birthDate;

    public Person(Instant birthDate) {
        this.birthDate = birthDate;
    }

    public Person() {

    }

    public Instant getBirthDate() {
        return birthDate;
    }
}
