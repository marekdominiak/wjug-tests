package com.dominiak.wjugtests.pitest;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    public void shouldAddNumbersProperly() throws Exception {
        Calculator calculator = new Calculator();

        assertThat(calculator.sum(2, 3) == 5);
    }
}