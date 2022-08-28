// Source : https://leetcode.com/problems/squares-of-a-sorted-array/
// Author : tindal-966
// Date   : 2022-08-28

/*****************************************************************************************************
 *
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each
 * number sorted in non-decreasing order.
 *
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
 *
 * Constraints:
 *
 * 	1 <= nums.length <= 10^4
 * 	-10^4 <= nums[i] <= 10^4
 * 	nums is sorted in non-decreasing order.
 *
 * Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n)
 * solution using a different approach?
 ******************************************************************************************************/
package org.example.squaresOfASortedArray;

/**
 * 1 ms	43.9 MB
 */
class Solution {
    public int[] sortedSquares(int[] nums) {
        int negativePivot = -1, positivePivot = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) negativePivot = i;
            if (positivePivot == -1 && nums[i] >= 0) positivePivot = i;
        }

        if (negativePivot == -1) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = nums[i] * nums[i];
            }

            return nums;
        }

        int[] result = new int[nums.length];
        if (positivePivot == -1) {
            for (int i = 0; i < nums.length; i++) {
                int v = nums[nums.length - 1 - i];
                result[i] = v * v;
            }

            return result;
        }

        int index = 0;
        while (negativePivot >= 0 && positivePivot < nums.length) {
            if (-nums[negativePivot] > nums[positivePivot]) {
                result[index++] = nums[positivePivot] * nums[positivePivot];
                positivePivot++;
            } else {
                result[index++] = nums[negativePivot] * nums[negativePivot];
                negativePivot--;
            }
        }
        if (index != nums.length) {
            if (negativePivot >= 0) {
                for (int i = index; i < nums.length; i++) {
                    result[i] = nums[negativePivot] * nums[negativePivot];
                    negativePivot--;
                }
            } else {
                for (int i = index; i < nums.length; i++) {
                    result[i] = nums[positivePivot] * nums[positivePivot];
                    positivePivot++;
                }
            }
        }

        return result;
    }
}


