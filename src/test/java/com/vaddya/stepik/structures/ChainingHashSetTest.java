package com.vaddya.stepik.structures;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ChainingHashSetTest {

    @Test
    public void testChainingHashSet() {
        ChainingHashSet set = new ChainingHashSet(5);
        set.add("world");
        set.add("HellO");
        Assert.assertEquals(List.of("HellO", "world"), set.check(4));
        Assert.assertFalse(set.find("World"));
        Assert.assertTrue(set.find("world"));
        set.del("world");
        Assert.assertEquals(List.of("HellO"), set.check(4));
    }
}
