package org.example.validAnagram;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAnagram(String s, String t) {
        Map<String, Integer> hashMap = new HashMap<>();

        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            String temp = String.valueOf(aChar);

            int count = 1;
            if (hashMap.containsKey(temp)) {
                count += hashMap.get(temp);
            }
            hashMap.put(temp, count);
        }

        char[] charsT = t.toCharArray();
        for (char aChar: charsT) {
            String temp = String.valueOf(aChar);

            if (!hashMap.containsKey(temp)) {
                return false;
            }

            Integer integer = hashMap.get(temp);
            integer--;
            if (integer < 0) {
                return false;
            } else if (integer == 0) {
                hashMap.remove(temp);
            } else {
                hashMap.put(temp, integer);
            }
        }

        return hashMap.keySet().size() == 0;
    }
}
