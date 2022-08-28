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
 * Notes:
 * 1. the minimum time-complexity of sorting method is O(nlog2n), so can't use
 * 2. create another array
 * 3. **the max value after square always appear in the first or the last**, so use two pivot to judge where is max
 */
class Solution {
    public int[] sortedSquares(int[] nums) {
        int forwardPivot = 0, reversePivot = nums.length - 1, index = nums.length - 1;
        int[] result = new int[nums.length];

        while (forwardPivot <= reversePivot) {
            int squareForward = nums[forwardPivot] * nums[forwardPivot];
            int squareReverse = nums[reversePivot] * nums[reversePivot];

            if (squareForward < squareReverse) {
                result[index--] = squareReverse;
                reversePivot--;
            } else {
                result[index--] = squareForward;
                forwardPivot++;
            }
        }

        return result;
    }
}

