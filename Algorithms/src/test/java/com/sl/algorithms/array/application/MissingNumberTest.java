package com.sl.algorithms.array.application;

import org.junit.Assert;
import org.junit.Test;

import static com.sl.algorithms.array.application.MissingNumber.*;

public class MissingNumberTest {
    @Test
    public void testFindSmallestMissingNumberSortedXOR() {
        Assert.assertEquals(0, findSmallestMissingNumberSortedXOR(new int[]{}));
        Assert.assertEquals(0, findSmallestMissingNumberSortedXOR(null));
        Assert.assertEquals(3, findSmallestMissingNumberSortedXOR(new int[]{0, 1, 2, 4, 5}));
    }

    @Test
    public void testFindSmallestMissingNumberSorted() {
        Assert.assertEquals(0, findSmallestMissingNumberSorted(new int[]{}));
        Assert.assertEquals(0, findSmallestMissingNumberSorted(null));
        Assert.assertEquals(3, findSmallestMissingNumberSorted(new int[]{0, 1, 2, 4, 5}));
        Assert.assertEquals(0, findSmallestMissingNumberSorted(new int[]{1, 2, 4, 5}));
        Assert.assertEquals(1, findSmallestMissingNumberSorted(new int[]{0, 2, 4, 5}));
        Assert.assertEquals(6, findSmallestMissingNumberSorted(new int[]{0, 1, 2, 3, 4, 5}));
    }

    @Test
    public void testFindSmallestMissingNumberUnsorted() {
        Assert.assertEquals(3, findSmallestMissingNumberUnsorted(new int[]{0, 0, 1, 2, 2, 4, 5}));
        Assert.assertEquals(3, findSmallestMissingNumberUnsorted(new int[]{0, 0, 1, 2, 4, 5}));
        Assert.assertEquals(4, findSmallestMissingNumberUnsorted(new int[]{5, 2, 3, 2, 2, 1}));
        Assert.assertEquals(4, findSmallestMissingNumberUnsorted(new int[]{-1, 1, 1, 2, 2, 3}));
        Assert.assertEquals(4, findSmallestMissingNumberUnsorted(new int[]{-1, 1, 2, 3}));
        Assert.assertEquals(1, findSmallestMissingNumberUnsorted(new int[]{-2, -3, -4, -8}));
        Assert.assertEquals(3, findSmallestMissingNumberUnsorted(new int[]{1, 2, 4, 5}));
        Assert.assertEquals(4, findSmallestMissingNumberUnsorted(new int[]{0, 1, 2, 3}));
        Assert.assertEquals(3, findSmallestMissingNumberUnsorted(new int[]{0, 1, 2, 4}));
        Assert.assertEquals(5, findSmallestMissingNumberUnsorted(new int[]{4, 1, 2, 3}));
        Assert.assertEquals(5, findSmallestMissingNumberUnsorted(new int[]{4, 2, 1, 3}));
        Assert.assertEquals(5, findSmallestMissingNumberUnsorted(new int[]{4, 2, 3, 1}));
        Assert.assertEquals(2, findSmallestMissingNumberUnsorted(new int[]{3, 4, -1, 1}));
        Assert.assertEquals(5, findSmallestMissingNumberUnsorted(new int[]{4, 3, 2, 1}));
        Assert.assertEquals(4, findSmallestMissingNumberUnsorted(new int[]{40, 1, 2, 3}));
        Assert.assertEquals(2, findSmallestMissingNumberUnsorted(new int[]{4, 1, 4, 3}));
        Assert.assertEquals(1, findSmallestMissingNumberUnsorted(new int[]{}));
    }
}
