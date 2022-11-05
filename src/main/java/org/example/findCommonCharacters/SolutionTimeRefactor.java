package org.example.findCommonCharacters;

import java.util.ArrayList;
import java.util.List;

class SolutionTimeRefactor {
    public List<String> commonChars(String[] words) {
        ArrayList<String> result = new ArrayList<>();
        if (words.length == 0) return result;

        int[] count = count(words[0]);
        for (int i = 1; i < words.length; i++) {
            count = getEachMin(count, count(words[i]));
        }

        for (int i = 0; i < 26; i++) {
            while (count[i]-- > 0) {
                result.add(String.valueOf((char)('a' + i)));
            }
        }

        return result;
    }

    public int[] count(String s) {
        int[] ints = new int[26];
        for (char c: s.toCharArray()) ints[c - 'a']++;

        return ints;
    }

    public int[] getEachMin(int[] a, int[] b) {
        int[] ints = new int[26];
        for (int i = 0; i < 26; i++) {
            ints[i] = Math.min(a[i], b[i]);
        }

        return ints;
    }
}
