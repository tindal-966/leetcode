// Source : https://leetcode.com/problems/minimum-size-subarray-sum/
// Author : tindal-966
// Date   : 2022-08-28

/*****************************************************************************************************
 *
 * Given an array of positive integers nums and a positive integer target, return the minimal length
 * of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or
 * equal to target. If there is no such subarray, return 0 instead.
 *
 * Example 1:
 *
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 *
 * Example 2:
 *
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 *
 * Example 3:
 *
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 *
 * Constraints:
 *
 * 	1 <= target <= 10^9
 * 	1 <= nums.length <= 10^5
 * 	1 <= nums[i] <= 10^4
 *
 * Follow up: If you have figured out the O(n) solution, try coding another solution of which the time
 * complexity is O(n log(n)).
 ******************************************************************************************************/
package org.example.minimumSizeSubarraySum;

/**
 * Notes:
 * 1. Slide window with two pivot
 * 2. **subtract in startPivot before startPivot move**
 */
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int startPivot = 0;

        int sum = 0, minimumLength = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                if (minimumLength == 0 || (i - startPivot + 1) < minimumLength) {
                    minimumLength = i - startPivot + 1;
                }

                sum -= nums[startPivot++];
            }
        }

        return minimumLength;
    }

    /**
     * nested for judge in LeetCode will cause overtime, see org.example.minimumSizeSubarraySum.SolutionTest#largeArray()
     *
     * Cons:
     * 1. do a lot of duplicate add method in the inner loop
     */
    public int minSubArrayLen_nestedFor(int target, int[] nums) {
        int minimalLength = 0;
        for (int startIndex = 0; startIndex < nums.length; startIndex++) {
            int sum = 0;
            for (int i = startIndex; i < nums.length; i++) {
                sum += nums[i];
                if (sum >= target) {
                    if (minimalLength == 0 || i - startIndex + 1 < minimalLength) { // Equal: minimalLength == 0 || (minimalLength != 0 && (i - startIndex < minimalLength))
                        minimalLength = i - startIndex + 1;
                    }
                    break;
                }
            }
        }

        return minimalLength;
    }
}


