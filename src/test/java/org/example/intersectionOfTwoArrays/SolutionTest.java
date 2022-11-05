package org.example.intersectionOfTwoArrays;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void example1() {
        // GIVEN
        int[] nums1 = new int[]{1, 2, 2, 1}, nums2 = new int[]{2, 2};
        int[] output = new int[]{2};

        // WHEN
        int[] result = new Solution().intersection(nums1, nums2);

        // THEN
        assertArrayEquals(
                Arrays.stream(output).sorted().toArray(),
                Arrays.stream(result).sorted().toArray()
        );
    }

    @Test
    public void example2() {
        // GIVEN
        int[] nums1 = new int[]{4, 9, 5}, nums2 = new int[]{9, 4, 9, 8, 4};
        int[] output = new int[]{9, 4};

        // WHEN
        int[] result = new SolutionArray().intersection(nums1, nums2);

        // THEN
        assertArrayEquals(
                Arrays.stream(output).sorted().toArray(),
                Arrays.stream(result).sorted().toArray()
        );
    }
}
