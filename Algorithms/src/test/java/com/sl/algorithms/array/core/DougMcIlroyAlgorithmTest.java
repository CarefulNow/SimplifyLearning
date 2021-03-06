package com.sl.algorithms.array.core;

import org.junit.Assert;
import org.junit.Test;

import static com.sl.algorithms.array.core.ArrayOps.printArray;

import static com.sl.algorithms.array.core.DougMcIlroyAlgorithm.rotateLeftByReversal;
import static com.sl.algorithms.array.core.DougMcIlroyAlgorithm.rotateRightByReversal;

public class DougMcIlroyAlgorithmTest {
    @Test
    public void testRotationLeftByReversal() {
        Assert.assertEquals("[2,3,4,5,1]", printArray(rotateLeftByReversal(new int[]{1, 2, 3, 4, 5}, 1)));
        Assert.assertEquals("[3,4,5,1,2]", printArray(rotateLeftByReversal(new int[]{1, 2, 3, 4, 5}, 2)));
        Assert.assertEquals("[4,5,1,2,3]", printArray(rotateLeftByReversal(new int[]{1, 2, 3, 4, 5}, 3)));
        Assert.assertEquals("[1,2,3,4,5]", printArray(rotateLeftByReversal(new int[]{1, 2, 3, 4, 5}, 5)));
        Assert.assertEquals("[5,1,2,3,4]", printArray(rotateLeftByReversal(new int[]{1, 2, 3, 4, 5}, 4)));
        Assert.assertEquals("[2,3,4,5,1]", printArray(rotateLeftByReversal(new int[]{1, 2, 3, 4, 5}, 6)));
        Assert.assertEquals("[3,4,5,1,2]", printArray(rotateLeftByReversal(new int[]{1, 2, 3, 4, 5}, 7)));
    }

    @Test
    public void testRotationRightByReversal() {
        Assert.assertEquals("[5,1,2,3,4]", printArray(rotateRightByReversal(new int[]{1, 2, 3, 4, 5}, 1)));
        Assert.assertEquals("[4,5,1,2,3]", printArray(rotateRightByReversal(new int[]{1, 2, 3, 4, 5}, 2)));
        Assert.assertEquals("[3,4,5,1,2]", printArray(rotateRightByReversal(new int[]{1, 2, 3, 4, 5}, 3)));
        Assert.assertEquals("[2,3,4,5,1]", printArray(rotateRightByReversal(new int[]{1, 2, 3, 4, 5}, 4)));
        Assert.assertEquals("[1,2,3,4,5]", printArray(rotateRightByReversal(new int[]{1, 2, 3, 4, 5}, 5)));
        Assert.assertEquals("[5,1,2,3,4]", printArray(rotateRightByReversal(new int[]{1, 2, 3, 4, 5}, 6)));
        Assert.assertEquals("[4,5,1,2,3]", printArray(rotateRightByReversal(new int[]{1, 2, 3, 4, 5}, 7)));
    }
}