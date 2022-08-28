package org.example.binarySearch;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example 1:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 *
 * Example 2:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 */
public class SolutionTest {
    @Test
    public void inArrays() {
        int[] a = {-1, 0, 3, 5, 9, 12};
        int target = 9;

        Assert.assertEquals(4, new Solution().search(a, target));
    }

    @Test
    public void notInArrays() {
        int[] a = {-1, 0, 3, 5, 9, 12};
        int target = 2;

        Assert.assertEquals(-1, new Solution().search(a, target));
    }
}
