package org.example.ransomNote;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void example() {
        // GIVEN
        Solution solution = new Solution();

        // THEN
        assertEquals(false, solution.canConstruct("a", "b"));
        assertEquals(false, solution.canConstruct("aa", "ab"));
        assertEquals(true, solution.canConstruct("aa", "aab"));
    }
}
