package org.example.happyNumber;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void example() {
        // GIVEN
        Solution solution = new Solution();

        // WHEN

        // THEN
        assertEquals(true, solution.isHappy(19));
        assertEquals(false, solution.isHappy(2));
        assertEquals(false, solution.isHappy(1999999999));
    }

}
