package org.example.reverseString;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void example() {
        // GIVEN
        Solution solution = new Solution();
        char[] chars1 = {'h', 'e', 'l', 'l', 'o'};
        char[] chars2 = {'H', 'a', 'n', 'n', 'a', 'h'};

        // THEN
        solution.reverseString(chars1);
        solution.reverseString(chars2);

        // THEN
        assertArrayEquals(new char[]{'o', 'l', 'l', 'e', 'h'}, chars1);
        assertArrayEquals(new char[]{'h', 'a', 'n', 'n', 'a', 'H'}, chars2);
    }
}
