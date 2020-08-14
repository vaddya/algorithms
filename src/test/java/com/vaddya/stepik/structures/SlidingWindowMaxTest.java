package com.vaddya.stepik.structures;

import org.junit.Assert;
import org.junit.Test;

public class SlidingWindowMaxTest {

    @Test
    public void testWindowMax() {
        check(4, a(2, 7, 3, 1, 5, 2, 6, 2), a(7, 7, 5, 6, 6));
        check(1, a(2, 1, 5), a(2, 1, 5));
        check(12, a(28, 7, 64, 40, 68, 86, 80, 93, 4, 53, 32, 56, 68, 18, 59), a(93, 93, 93, 93));
        check(5, a(27,83,29,77,6,3,48,2,16,72,46,38,55,2,58), a(83,83,77,77,48,72,72,72,72,72,58));
    }

    private void check(int windowSize, int[] array, int[] expected) {
        int[] max = SlidingWindowMax.windowMax(array, windowSize);
        Assert.assertArrayEquals(expected, max);
    }

    private int[] a(int... elements) {
        return elements;
    }
}