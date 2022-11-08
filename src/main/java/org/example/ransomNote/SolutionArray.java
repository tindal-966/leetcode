package org.example.ransomNote;

import java.util.HashMap;
import java.util.Map;

class SolutionArray {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] ints = new int[26];

        char[] magChars = magazine.toCharArray();
        for (char c: magChars) {
            ints[c - 'a']++;
        }

        char[] noteChars = ransomNote.toCharArray();
        for (char c: noteChars) {
            ints[c - 'a']--;
            if (ints[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
