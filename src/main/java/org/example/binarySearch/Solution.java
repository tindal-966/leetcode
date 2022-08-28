// Source : https://leetcode.com/problems/binary-search/
// Author : tindal-966
// Date   : 2022-08-28

/*****************************************************************************************************
 *
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a
 * function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
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
 *
 * Constraints:
 *
 * 	1 <= nums.length <= 10^4
 * 	-10^4 < nums[i], target < 10^4
 * 	All the integers in nums are unique.
 * 	nums is sorted in ascending order.
 ******************************************************************************************************/
package org.example.binarySearch;

class Solution {
    public int search(int[] nums, int target) {
        // Board check
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }

        int middle, left = 0, right = nums.length;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (target < nums[middle]) {
                right = middle - 1;
            } else if (target > nums[middle]) {
                left = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;
    }
}

