package org.example._4sum;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void example() {
        commonAssert(new int[]{1, 0, -1, 0, -2, 2}, 0, new int[][]{{-2, -1, 1, 2}, {-2, 0, 0, 2}, {-1, 0, 0, 1}});
        commonAssert(new int[]{2, 2, 2, 2, 2}, 8, new int[][]{{2, 2, 2, 2}});
    }

    private void commonAssert(int[] nums, int target, int[][] output) {
        // GIVEN

        // WHEN
        List<List<Integer>> lists = new Solution().fourSum(nums, target);

        // THEN
        org.example._3sum.SolutionTest solutionTest = new org.example._3sum.SolutionTest();
        assertArrayEquals(solutionTest.sort(output), solutionTest.sort(lists));
    }

}
