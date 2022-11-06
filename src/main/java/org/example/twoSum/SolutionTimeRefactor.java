package org.example.twoSum;

import java.util.*;

class SolutionTimeRefactor extends Solution {
    @Override
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, List<Integer>> map = new HashMap<>(); // Map<Nums, IndexList>

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }

            int difference = target - nums[i];
            if (map.containsKey(difference) &&
                    ((map.get(difference).size() > 1) || // 排除同样的数字
                            (map.get(difference).size() == 1 && map.get(difference).get(0) != i))) { // 排除自身
                result[0] = i;
                for (Integer index: map.get(difference)) {
                    if (index != i) {
                        result[1] = index;
                        return result;
                    }
                }

            }
        }

        return result;
    }
}
