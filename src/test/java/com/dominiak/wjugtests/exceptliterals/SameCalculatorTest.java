package com.dominiak.wjugtests.exceptliterals;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class SameCalculatorTest {

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
        Calculator calc = new Calculator();
        Assertions.assertThat(calc.add(2, 2)).isEqualTo(4);
    }
}
