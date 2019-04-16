package com.vaddya.stepik.algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {

    @Test
    public void find0() {
        int f = Fibonacci.findNth(0);

        assertEquals(0, f);
    }

    @Test
    public void find1() {
        int f = Fibonacci.findNth(1);

        assertEquals(1, f);
    }

    @Test
    public void findNth() {
        int f = Fibonacci.findNth(10);

        assertEquals(55, f);
    }

    @Test
    public void findNth2() {
        int f1 = Fibonacci.findNth(10);
        int f2 = Fibonacci.findNth(11);
        int f  = Fibonacci.findNth(12);

        assertEquals(f1 + f2, f);
    }

    @Test
    public void findLastDigit() {
        int f = Fibonacci.findLastDigit(317457);

        assertEquals(2, f);
    }

    @Test
    public void findModulo() {
        long n = 10;
        int m = 2;
        long mod = Fibonacci.findModulo(n, m);

        assertEquals(1, mod);
    }
}