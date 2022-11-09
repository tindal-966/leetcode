package org.example.reverseString;

class Solution {
    public void reverseString(char[] s) {
        if (s.length < 2) {
            return;
        }

        for (int i = 0; i < s.length / 2; i++) {
            char tmp = s[s.length - 1 - i];
            s[s.length - 1 - i] = s[i];
            s[i] = tmp;
        }
    }
}
