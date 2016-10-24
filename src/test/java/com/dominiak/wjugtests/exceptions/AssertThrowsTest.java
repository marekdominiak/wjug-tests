package com.dominiak.wjugtests.exceptions;

import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertThrowsTest {
    @Test
    public void oldGoodWay() throws Exception {
        // given
        String name = null;

        try {
            // when
            safeBusinessMethod(name);
            Assert.fail("Should throw NPE!");
        } catch (NullPointerException ex) {
            // then ok
        }
    }

    @Test
    public void shouldCatchExceptionOnlyByAssertThrown() throws Exception {
        //given
        String name = null;
        // when & then
        Assertions.assertThatThrownBy(() -> safeBusinessMethod(name))
                .isInstanceOf(NullPointerException.class);
    }

    @Test(expectedExceptions = NullPointerException.class)//then ;)
    public void showFlawInExpectedException() throws Exception {
        // given
        setup();
        String name = null;

        //when
        businessMethod2(name);
    }

    private void setup() {
        throw new NullPointerException();
    }

    private String safeBusinessMethod(String name) {
        return name.trim();
    }

    private String businessMethod2(String name) {
        return "very funny";
    }
}
