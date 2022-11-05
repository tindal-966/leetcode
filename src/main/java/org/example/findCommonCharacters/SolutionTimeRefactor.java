package org.example.findCommonCharacters;

import java.util.ArrayList;
import java.util.List;

class SolutionTimeRefactor {
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        if (words.length == 0) return result;

        int[] lowercaseLetters = new int[26];
        words[0].chars().forEach(c -> lowercaseLetters[c - 'a']++);

        for (int i = 1; i < words.length; i++) {
            int[] temp =  new int[26];
            words[i].chars().forEach(c -> temp[c - 'a']++);

            // update lowercaseLetters
            for (int j = 0; j < 26; j++) {
                if (lowercaseLetters[j] != 0) {
                    lowercaseLetters[j] = Math.min(temp[j], lowercaseLetters[j]);
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            while (lowercaseLetters[i] != 0) {
                result.add(String.valueOf(c));
                lowercaseLetters[i]--;
            }
        }

        return result;
    }
}
