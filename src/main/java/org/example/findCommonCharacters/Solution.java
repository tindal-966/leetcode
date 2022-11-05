package org.example.findCommonCharacters;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        if (words.length == 0) return result;

        char[] chars = words[0].toCharArray();
        int[] count = new int[chars.length];

        for (int i = 1; i < words.length; i++) {
            for (char c: words[i].toCharArray()) {
                for (int i_chars = 0; i_chars < chars.length; i_chars++) {
                    if (c == chars[i_chars] && count[i_chars] == i - 1) {
                        count[i_chars]++;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < chars.length; i++) {
            if (count[i] == (words.length - 1)) {
                result.add(String.valueOf(chars[i]));
            }
        }

        return result;
    }
}
