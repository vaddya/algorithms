package com.vaddya.stepik.algorithms;

import com.vaddya.stepik.algorithms.ContinuousBackpack.Thing;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ContinuousBackpackTest {

    @Test
    public void test() {
        int capacity = 50;
        List<Thing> things = new ArrayList<>(List.of(
                Thing.from(60, 20),
                Thing.from(100, 50),
                Thing.from(120, 30)
        ));

        double cost = ContinuousBackpack.maximizeCost(things, capacity);

        assertEquals(180, cost, 0.1);
    }

}