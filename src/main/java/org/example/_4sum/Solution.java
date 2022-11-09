package org.example._4sum;

import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0 && nums[i] > target) {
                break;
            }

            if (noFirstTimeInLoop(i, 0) && nums[i] == nums[i - 1]) { // skip equal
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] >= 0 && nums[i] + nums[j] > target) {
                    break;
                }

                if (noFirstTimeInLoop(j, i + 1) && nums[j] == nums[j - 1]) { // skip equal
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long sum = sum(nums[i], nums[j], nums[left], nums[right]);
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        result.add(toList(nums[i], nums[j], nums[left], nums[right]));

                        while (left < right && nums[left + 1] == nums[left]) left++;
                        while (left < right && nums[right - 1] == nums[right]) right--;

                        left++;
                        right--;
                    }
                }
            }
        }

        return result;
    }

    private boolean noFirstTimeInLoop(int currentIndex, int startIndex) {
        return currentIndex > startIndex;
    }

    private long sum(int... params) {
        long result = 0L;
        for (int param : params) {
            result += param;
        }

        return result;
    }

    private List<Integer> toList(int... params) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int param : params) {
            result.add(param);
        }

        return result;
    }
}
