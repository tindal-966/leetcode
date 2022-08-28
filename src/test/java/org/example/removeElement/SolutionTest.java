package org.example.removeElement;

import com.google.common.primitives.Ints;
import org.junit.Assert;
import org.junit.Test;

/**
 * Custom Judge:
 *
 * The judge will test your solution with the following code:
 *
 * int[] nums = [...]; // Input array
 * int val = ...; // Value to remove
 * int[] expectedNums = [...]; // The expected answer with correct length.
 *                             // It is sorted with no values equaling val.
 *
 * int k = removeElement(nums, val); // Calls your implementation
 *
 * assert k == expectedNums.length;
 * sort(nums, 0, k); // Sort the first k elements of nums
 * for (int i = 0; i < actualLength; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 *
 * If all assertions pass, then your solution will be accepted.
 *
 * Example 1:
 *
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2,_,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 2.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 * Example 2:
 *
 * Input: nums = [0,1,2,2,3,0,4,2], val = 2
 * Output: 5, nums = [0,1,4,0,3,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums containing 0,
 * 0, 1, 3, and 4.
 * Note that the five elements can be returned in any order.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 */
public class SolutionTest {
    @Test
    public void test1() {
        int[] nums = {3,2,2,3};
        int val = 3;

        int[] exceptedNums = {2, 2};

        test(nums, val, exceptedNums);
    }

    @Test
    public void test2() {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;

        int[] exceptedNums = {0,1,4,0,3};

        test(nums, val, exceptedNums);
    }

    @Test
    public void testAllOccurrence() {
        int[] nums = {2,2,2,2,2,2,2,2};
        int val = 2;

        int[] exceptedNums = {};

        test(nums, val, exceptedNums);
    }

    @Test
    public void testNoOccurrence() {
        int[] nums = {2,2,2,2,2,2,2,2};
        int val = 9;

        int[] exceptedNums = {2,2,2,2,2,2,2,2};

        test(nums, val, exceptedNums);
    }

    public void test(int[] nums, int val, int[] exceptedNums) {
        int result = new Solution().removeElement(nums, val);

        Assert.assertEquals(exceptedNums.length, result);
        Assert.assertArrayEquals(
                // Arrays.asList with base type just put whole array as First element in list
                Ints.asList(exceptedNums).stream().sorted().toArray(),
                Ints.asList(nums).subList(0, exceptedNums.length).stream().sorted().toArray());
    }
}
