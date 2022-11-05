package org.example.intersectionOfTwoArrays;

class SolutionArray {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] ints = new int[1000];
        for (int i: nums1) {
            ints[i] = 1;
        }

        int count = 0;
        int[] temp = new int[nums1.length]; // nums1.length or nums1.length is OK
        for (int i: nums2) {
            if (ints[i] == 1) { // avoid duplicate
                temp[count++] = i;
                ints[i]++; // avoid duplicate
            }
        }

        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }

        return result;
    }
}
