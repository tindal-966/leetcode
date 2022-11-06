package org.example.happyNumber;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (n != 1 && !set.contains(n)) {
            set.add(n);

            int sum = 0;
            while (n > 0) {
                int temp = n % 10;
                sum += temp * temp;
                n = n / 10;
            }
            n = sum;
        }

        return n == 1;
    }

    private int[] splitByDigit(int n) {
        if (n < 0) n = -n;

        int temp = n;
        int count = 0; // no 1
        while (temp > 0) {
            count++;
            temp /= 10;
        }

        int[] ints = new int[count];
        for (int i = 0; i < count; i++) {
            ints[ints.length - 1 - i] = n % 10;
            n = n / 10;
        }

        return ints;
    }
}
