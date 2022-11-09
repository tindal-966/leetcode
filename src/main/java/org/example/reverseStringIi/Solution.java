package org.example.reverseStringIi;

class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();

        int i = 0;
        while (i < chars.length) {
            reverse(chars, i, Math.min(i + k - 1, chars.length - 1));
            i += (2 * k);
        }

        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            chars[startIndex] ^= chars[endIndex];
            chars[endIndex] ^= chars[startIndex];
            chars[startIndex] ^= chars[endIndex];

            startIndex++;
            endIndex--;
        }
    }
}
