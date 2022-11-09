package org.example._3sum;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<String> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length && j != i; j++) {
                for (int k = 0; k < length && k != i && k != j; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        if (!set.contains(getSetKey(nums[i], nums[j], nums[k]))) {
                            result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                            set.add(getSetKey(nums[i], nums[j], nums[k]));
                        }
                    }
                }
            }
        }

        return result;
    }

    private String getSetKey(int i1, int i2, int i3) {
        int[] ints = {i1, i2, i3};
        return Arrays.stream(ints)
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}
