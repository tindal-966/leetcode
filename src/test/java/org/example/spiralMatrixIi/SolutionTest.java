package org.example.spiralMatrixIi;

import org.junit.Assert;
import org.junit.Test;

/**
 * Example 1:
 * <p>
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 * <p>
 * Example 2:
 * <p>
 * Input: n = 1
 * Output: [[1]]
 */
public class SolutionTest {
    @Test
    public void test3() {
        Assert.assertArrayEquals(new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}},
                new Solution().generateMatrix(3));
    }

    @Test
    public void test1() {
        Assert.assertArrayEquals(new int[][]{{1}}, new Solution().generateMatrix(1));
    }
}
