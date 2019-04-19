package com.vaddya.stepik.algorithms;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class VariousTermTest {

    @Test
    public void test1() {
        List<Integer> terms = VariousTerm.find(4);

        assertEquals(2, terms.size());
        assertEquals(List.of(1, 3), terms);
    }

    @Test
    public void test2() {
        List<Integer> terms = VariousTerm.find(6);

        assertEquals(3, terms.size());
        assertEquals(List.of(1, 2, 3), terms);
    }


    @Test
    public void test3() {
        List<Integer> terms = VariousTerm.find(7);

        assertEquals(3, terms.size());
        assertEquals(List.of(1, 2, 4), terms);
    }
}
