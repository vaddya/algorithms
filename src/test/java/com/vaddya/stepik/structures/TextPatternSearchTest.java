package com.vaddya.stepik.structures;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TextPatternSearchTest {

    @Test
    public void findPattern() {
        Assert.assertEquals(List.of(0), TextPatternSearch.findPattern("Test0", "Test"));
        Assert.assertEquals(List.of(0, 4), TextPatternSearch.findPattern("abacaba", "aba"));
        Assert.assertEquals(List.of(1, 2, 3), TextPatternSearch.findPattern("baaaaaaa", "aaaaa"));
    }
}
