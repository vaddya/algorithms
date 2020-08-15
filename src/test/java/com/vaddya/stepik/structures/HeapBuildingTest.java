package com.vaddya.stepik.structures;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class HeapBuildingTest {

    @Test
    public void testHeapify() {
        int[] array = new int[]{7, 6, 5, 4, 3, 2};
        List<HeapBuilding.Swap> swaps = HeapBuilding.heapify(array);
        Assert.assertEquals(4, swaps.size());
        Assert.assertEquals(1, swaps.get(1).from);
        Assert.assertEquals(4, swaps.get(1).to);
    }
}
