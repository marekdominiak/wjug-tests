package com.dominiak.wjugtests.exceptions;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class AssertThrowsTest {
    @Test
    public void shouldCatchExceptionOnlyByAssertThrown() throws Exception {
        String name = null;
        Assertions.assertThatThrownBy(() -> businessMethod(name))
                .isInstanceOf(NullPointerException.class);
    }
    @Test(expectedExceptions = NullPointerException.class)
    public void showFlawInExpectedException() throws Exception {
        setup();
        String name = null;

        businessMethod2(name);
    }
    private void setup() {
        throw new NullPointerException();
    }
    private String businessMethod(String name) {
        return name.trim();
    }
    private String businessMethod2(String name) {
        return "very funny";
    }
}
