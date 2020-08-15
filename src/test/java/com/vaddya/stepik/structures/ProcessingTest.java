package com.vaddya.stepik.structures;

import org.junit.Assert;
import org.junit.Test;

public class ProcessingTest {

    @Test
    public void testProcess() {
        long[] times = new long[]{1, 2, 3, 4, 5};
        Processing.Work[] works = Processing.process(2, times);
        Assert.assertEquals(times.length, works.length);
        Assert.assertEquals(1, works[3].processor);
        Assert.assertEquals(2, works[3].time - times[3]);
    }
}
