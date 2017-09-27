package com.dominiak.wjugtests.setup;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.time.Instant;
import java.time.LocalDate;

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
    public void defaultPersonShouldBeInHis20s() throws Exception {
        Person person = new Person(LocalDate.parse("1992-12-03"));

        Assertions.assertThat(person.getBirthDate())
                .isAfter(LocalDate.parse("1986-12-03"))
                .isBefore(LocalDate.parse("1996-12-03"));
    }
}
