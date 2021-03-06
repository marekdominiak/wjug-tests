package com.dominiak.wjugtests.setup;

import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class PersonTest extends BasePersonTest {
    private static final LocalDate THRESHOLD_1 = LocalDate.parse("1990-01-01");

    @BeforeMethod
    public void setUp() throws Exception {
        super.setUpBase();

    }

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
        Person person = newPerson();

        Assertions.assertThat(person.getBirthDate())
                .isAfterOrEqualTo(THRESHOLD_1)
                .isBefore(upperThreshold());
    }


    @Test
    public void emptyMethodJustToMakeThingsHarder6() throws Exception {


    }

    @Test
    public void emptyMethodJustToMakeThingsHarder7() throws Exception {


    }

    //    @Test
//    public void personBirthdayShouldBeIn90s() throws Exception {
//        Person person = new Person(Instant.parse("2007-12-03T10:15:30.00Z"));
//
//        Assertions.assertThat(person.getBirthDate())
//                .isBetween(Instant.parse("1986-12-03T10:15:30.00Z"),
//                        Instant.parse("1996-12-03T10:15:30.00Z"));
//    }
}
