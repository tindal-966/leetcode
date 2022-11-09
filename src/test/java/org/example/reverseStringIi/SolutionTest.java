package org.example.reverseStringIi;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void example() {
        // GIVEN
        Solution solution = new Solution();

        // WHEN
        String s1 = solution.reverseStr("abcdefg", 2);
        String s2 = solution.reverseStr("abcd", 2);

        // THEN
        assertEquals("bacdfeg", s1);
        assertEquals("bacd", s2);
    }

    @Test
    public void error() {
        // GIVEN
        Solution solution = new Solution();

        // WHEN
        String s = solution.reverseStr("a", 2);

        // THEN
        assertEquals("a", s);
    }
}
