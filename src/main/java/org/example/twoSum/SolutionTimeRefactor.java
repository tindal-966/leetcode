package org.example.twoSum;

import java.util.*;

class SolutionTimeRefactor extends Solution {
    @Override
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>(); // 因为有且只有一个结果，所以不会出现一个数字多次出现但这个数字不是结果的情况（可以有一个数字出现多次，但是这个数字一定不是结果中的一个，所以此时只记一个下标就可以了）

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (map.containsKey(difference)) {
                result[0] = i;
                result[1] = map.get(difference);
                return result;
            }

            map.put(nums[i], i);
        }

        return result;
    }
}
