package com.vaddya.stepik.structures;

import org.junit.Assert;
import org.junit.Test;

public class TreeHeightTest {

    @Test
    public void testFindTreeHeight() {
        /*  
            1
           / \
           3  4
             / \
             0  2
         */
        int[] tree = new int[]{4, -1, 4, 1, 1};
        int height = TreeHeight.findTreeHeight(tree);
        Assert.assertEquals(3, height);
    }
}