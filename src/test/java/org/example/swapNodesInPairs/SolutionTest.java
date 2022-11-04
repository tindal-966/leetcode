package org.example.swapNodesInPairs;

import org.example.lib.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void example1() {
        // Given
        int[] ints = {1,2,3,4};
        int[] expected = {2,1,4,3};

        commonAssert(ints, expected);
    }

    @Test
    public void example2() {
        // Given
        int[] ints = {};
        int[] expected = {};

        commonAssert(ints, expected);
    }

    @Test
    public void example3() {
        // Given
        int[] ints = {1};
        int[] expected = {1};

        commonAssert(ints, expected);
    }

    public void commonAssert(int[] input, int[] output) {
        // WHEN
        ListNode listNode = ListNode.array2ListNode(input);
        int[] actual = ListNode.listNode2Array(new Solution().swapPairs(listNode));

        // THEN
        assertArrayEquals(output, actual);
    }
}
