package org.example.ransomNote;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        Map<String, Integer> map = new HashMap<>();

        char[] magChars = magazine.toCharArray();
        for (char c: magChars) {
            String s = String.valueOf(c);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        char[] noteChars = ransomNote.toCharArray();
        for (char c: noteChars) {
            String s = String.valueOf(c);
            if (!map.containsKey(s) || map.get(s) <= 0) {
                return false;
            } else {
                map.put(s, map.get(s) - 1);
            }
        }

        return true;
    }
}
