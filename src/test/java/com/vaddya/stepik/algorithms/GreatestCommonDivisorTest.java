package com.vaddya.stepik.algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreatestCommonDivisorTest {

    @Test
    public void test1() {
        int gcd = GreatestCommonDivisor.find(18, 35);

        assertEquals(1, gcd);
    }

    @Test
    public void test2() {
        int gcd = GreatestCommonDivisor.find(14159572, 63967072);

        assertEquals(4, gcd);
    }

}