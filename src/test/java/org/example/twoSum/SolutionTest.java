package org.example.twoSum;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void example() {
        commonAssert(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1});
        commonAssert(new int[]{3, 2, 4}, 6, new int[]{1, 2});
        commonAssert(new int[]{3, 3}, 6, new int[]{0, 1});
    }

    @Test
    public void edge() {
//        commonAssert(new int[]{2, 7, 11, 15}, 30, new int[0]); // always one answer
//        commonAssert(new int[]{2}, 2, new int[0]); // 2 <= nums.length

        commonAssert(new int[]{-1, -2, 3, 5}, 2, new int[]{0, 2});
        commonAssert(new int[]{-1, -2, -3, -4}, -3, new int[]{0, 1});
    }

    private void commonAssert(int[] mums, int target, int[] output) {
        // WHEN
        int[] ints = new Solution().twoSum(mums, target);

        // THEN
        assertArrayEquals(
                Arrays.stream(output).sorted().toArray(),
                Arrays.stream(ints).sorted().toArray()
        );
    }
}
