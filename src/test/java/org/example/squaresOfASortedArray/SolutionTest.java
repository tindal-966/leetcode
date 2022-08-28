package org.example.squaresOfASortedArray;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example 1:
 *
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 *
 * Example 2:
 *
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 */
public class SolutionTest {
    @Test
    public void test1() {
        int[] nums = {-4,-1,0,3,10};
        int[] expectedNums = {0,1,9,16,100};

        Assert.assertArrayEquals(new Solution().sortedSquares(nums), expectedNums);
    }

    @Test
    public void test2() {
         int[] nums = {-7,-3,2,3,11};
         int[] expectedNums = {4,9,9,49,121};

        Assert.assertArrayEquals(new Solution().sortedSquares(nums), expectedNums);
    }

    @Test
    public void allNegative() {
        int[] nums = {-8,-6,-4,-2};
        int[] expectedNums = {4, 16, 36, 64};

        Assert.assertArrayEquals(new Solution().sortedSquares(nums), expectedNums);
    }

    @Test
    public void allPositive() {
        int[] nums = {2,4,6,8};
        int[] expectedNums = {4,16,36,64};

        Assert.assertArrayEquals(new Solution().sortedSquares(nums), expectedNums);
    }

    @Test
    public void oneNeOnePo() {
        int[] nums = {-2, 0};
        int[] expectedNums = {0, 4};

        Assert.assertArrayEquals(new Solution().sortedSquares(nums), expectedNums);
    }
}
