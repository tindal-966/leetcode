package org.example.validAnagram;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void example() {
        // GIVEN
        Solution solution = new Solution();

        // THEN
        assertTrue(solution.isAnagram("anagram", "nagaram"));
        assertFalse(solution.isAnagram("rat", "cat"));
    }

}
