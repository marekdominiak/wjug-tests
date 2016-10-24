package com.dominiak.wjugtests.exceptliterals;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class FuzzyCalculatorTest {
    int numberA = 2;
    int numberB = 2;

    @Test
    public void test1() throws Exception {

    }
    @Test
    public void test2() throws Exception {

    }
    @Test
    public void test3() throws Exception {

    }
    @Test
    public void test4() throws Exception {

    }
    @Test
    public void test5() throws Exception {

    }

    @Test
    public void shouldAddNumbersCorrectly() throws Exception {
        // given
        Calculator calc = new Calculator();

        // when
        int sum = calc.add(numberA, numberB);

        //then
        Assertions.assertThat(sum).isEqualTo(numberA + numberB);
    }
}
