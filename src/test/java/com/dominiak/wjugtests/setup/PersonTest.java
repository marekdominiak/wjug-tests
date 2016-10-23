package com.dominiak.wjugtests.setup;

import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Instant;

public class PersonTest extends BasePersonTest {
    private static final Instant THRESHOLD_1 = Instant.parse("1986-12-03T10:15:30.00Z");

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
    public void defaultPersonShouldBeInHis20s() throws Exception {
        Instant maxInstant = maxInstant();
        Person person = newPerson();

        Assertions.assertThat(person.getBirthDate())
                .isBetween(THRESHOLD_1, maxInstant);
    }

    @Test
    public void emptyMethodJustToMakeThingsHarder6() throws Exception {


    }

    @Test
    public void emptyMethodJustToMakeThingsHarder7() throws Exception {


    }

    @Test
    public void defaultPersonShouldBeBornOnAParticularDate() throws Exception {
        Instant expectedBirthDate = Instant.parse("1986-12-03T10:15:30.00Z");
        Person person = newPerson();
        Instant birthDate = person.getBirthDate();

        Assertions.assertThat(birthDate)
                .isEqualTo(expectedBirthDate);
    }

}
