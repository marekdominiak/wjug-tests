package com.dominiak.wjugtests.springsecurity;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

public class Assert {
    public static void hasText(String text, String msg) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(text), msg);
    }

    public static void notNull(Object object, String msg) {
        Preconditions.checkNotNull(object, msg);
    }
}
