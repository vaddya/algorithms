package com.vaddya.stepik.structures;

import org.junit.Assert;
import org.junit.Test;

public class BracketsCheckerTest {

    @Test
    public void checkParentheses() {
        // ok
        check(-1, "[]");
        check(-1, "{}[]");
        check(-1, "[()]");
        check(-1, "(())");
        check(-1, "{[]}()");
        check(-1, "foo(bar);");
        // errors
        check(1, "{");
        check(3, "{[}");
        check(10, "foo(bar[i);");
    }

    private void check(int expected, String text) {
        Assert.assertEquals(expected, BracketsChecker.checkParentheses(text));
    }
}