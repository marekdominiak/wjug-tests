package com.dominiak.wjugtests.setup;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.time.Instant;

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
        Person person = new Person(Instant.parse("2007-12-03T10:15:30.00Z"));

        Assertions.assertThat(person.getBirthDate())
                .isBetween(Instant.parse("1986-12-03T10:15:30.00Z"),
                        Instant.parse("1996-12-03T10:15:30.00Z"));
    }
}
