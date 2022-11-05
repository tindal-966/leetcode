package org.example.findCommonCharacters;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void example1() {
        // GIVEN
        String[] words = {"bella", "label", "roller"};
        List<String> output = Arrays.asList("e", "l", "l");

        // WHEN
        List<String> result = new Solution().commonChars(words);

        // THEN
        assertArrayEquals(output.stream().sorted().toArray(), result.stream().sorted().toArray());
    }

    @Test
    public void example2() {
        // GIVEN
        String[] words = {"cool", "lock", "cook"};
        List<String> output = Arrays.asList("c", "o");

        // WHEN
        List<String> result = new Solution().commonChars(words);

        // THEN
        assertArrayEquals(output.stream().sorted().toArray(), result.stream().sorted().toArray());
    }

    @Test
    public void example_e1() {
        // GIVEN
        String[] words = {"acabcddd","bcbdbcbd","baddbadb","cbdddcac","aacbcccd","ccccddda","cababaab","addcaccd"};
        List<String> output = Arrays.asList();

        // WHEN
        List<String> result = new Solution().commonChars(words);

        // THEN
        assertArrayEquals(output.stream().sorted().toArray(), result.stream().sorted().toArray());
    }
}
