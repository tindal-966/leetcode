package org.example.validAnagram;

class SolutionArray {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] lowercaseEnglishLetters = new int[26]; // lowercase English letters has 26

        s.chars().forEach(c -> lowercaseEnglishLetters[c - 'a']++);
        t.chars().forEach(c -> lowercaseEnglishLetters[c - 'a']--);

        for (int i: lowercaseEnglishLetters) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
