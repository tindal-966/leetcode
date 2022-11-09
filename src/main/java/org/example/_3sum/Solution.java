package org.example._3sum;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, List<Set<Integer>>> map = new HashMap<>(); // Map<sum, List<IndexTuple>>
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length && j != i; j++) { // i != j
                int sum = nums[i] + nums[j];

                Set<Integer> set = new HashSet<>();
                set.add(i);
                set.add(j);

                List<Set<Integer>> orDefault = map.getOrDefault(sum, new ArrayList<>());
                orDefault.add(set);

                map.put(sum, orDefault);
            }
        }

        Set<String> resultSet = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(-nums[i])) {
                List<Set<Integer>> lists = map.get(-nums[i]);
                for (Set<Integer> set : lists) {
                    String setKey = getSetKey(nums[i], nums, set.toArray(new Integer[0]));
                    if (!set.contains(i) && !resultSet.contains(setKey)) { // k != i, k != j
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        set.forEach(e -> tmp.add(nums[e]));

                        result.add(tmp);
                        resultSet.add(setKey);
                    }
                }
            }
        }

        return result;
    }

    private String getSetKey(int i1, int[] nums, Integer[] indexList) {
        int[] newInts = new int[]{i1, nums[indexList[0]], nums[indexList[1]]};
        return Arrays.stream(newInts)
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}
