package com.vaddya.stepik.structures;

import org.junit.Assert;
import org.junit.Test;

public class MaxStackTest {

    @Test
    public void testMaxStack1() {
        MaxStack maxStack = new MaxStack();
        maxStack.push(2);
        maxStack.push(1);
        Assert.assertEquals(2, maxStack.max());
        maxStack.pop();
        Assert.assertEquals(2, maxStack.max());
    }

    @Test
    public void testMaxStack2() {
        MaxStack maxStack = new MaxStack();
        maxStack.push(7);
        maxStack.push(1);
        maxStack.push(7);
        Assert.assertEquals(7, maxStack.max());
        maxStack.pop();
        Assert.assertEquals(7, maxStack.max());
    }

    @Test
    public void testMaxStack3() {
        MaxStack maxStack = new MaxStack();
        maxStack.push(1);
        maxStack.push(2);
        Assert.assertEquals(2, maxStack.max());
        maxStack.pop();
        Assert.assertEquals(1, maxStack.max());
    }

    @Test
    public void testMaxStack4() {
        MaxStack maxStack = new MaxStack();
        maxStack.push(2);
        maxStack.push(3);
        maxStack.push(9);
        maxStack.push(7);
        maxStack.push(2);
        Assert.assertEquals(9, maxStack.max());
        Assert.assertEquals(9, maxStack.max());
        Assert.assertEquals(9, maxStack.max());
        maxStack.pop();
        Assert.assertEquals(9, maxStack.max());
    }
}