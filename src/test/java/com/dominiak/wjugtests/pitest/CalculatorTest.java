package com.dominiak.wjugtests.pitest;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class CalculatorTest {
    @Test
    public void trickyTestWithNoAssertions() throws Exception {
        Calculator calculator = new Calculator();

        Assertions.assertThat(calculator.sum(2, 2));
    }

    @Test
    public void betterTestWithAssertion() throws Exception {
        Calculator calculator = new Calculator();

        Assertions.assertThat(calculator.sum(2, 2)).isEqualTo(4);
    }
}