package com.dominiak.wjugtests.setup;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.time.Instant;
import java.time.LocalDate;

import static java.time.LocalDate.parse;

public class SanePersonTest extends BasePersonTest {

    @Test
    public void emptyMethodJustToMakeThingsHarder() throws Exception {


    }

    @Test
    public void emptyMethodJustToMakeThingsHarder2() throws Exception {


    }

    @Test
    public void emptyMethodJustToMakeThingsHarder3() throws Exception {


    }

    @Test
    public void emptyMethodJustToMakeThingsHarder4() throws Exception {


    }

    @Test
    public void emptyMethodJustToMakeThingsHarder5() throws Exception {


    }

    @Test
    public void personShouldBeBornIn90s() throws Exception {
        Person person = new Person(date("1992-12-03"));

        Assertions.assertThat(person.getBirthDate())
                .isAfterOrEqualTo(date("1990-01-01"))
                .isBefore(date("2000-01-01"));
    }

    private LocalDate date(String text) {
        return parse(text);
    }
}
