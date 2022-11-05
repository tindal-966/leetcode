package org.example.intersectionOfTwoArrays;

import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i: nums1) {
            set1.add(i);
        }

        Set<Integer> result = new HashSet<>();
        for (int i: nums2) {
            if (set1.contains(i)) {
                result.add(i);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
