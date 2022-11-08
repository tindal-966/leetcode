package org.example._4sumIi;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();

        int count = 0;
        for (int i1: nums1) {
            for (int i2: nums2) {
                int sum = i1 + i2;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for (int i3: nums3) {
            for (int i4: nums4) {
                count += map.getOrDefault(-(i3+i4), 0);
            }
        }

        return count;
    }
}
