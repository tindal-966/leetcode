package org.example.removeNthNodeFromEndOfList;

import org.example.lib.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void example1() {
        // Given
        int[] head = {1, 2, 3, 4, 5};
        int n = 2;
        int[] output = {1, 2, 3, 5};

        commonAssert(head, n, output);
    }

    @Test
    public void example2() {
        // Given
        int[] head = {1};
        int n = 1;
        int[] output = {};

        commonAssert(head, n, output);
    }

    @Test
    public void example3() {
        // Given
        int[] head = {1, 2};
        int n = 1;
        int[] output = {1};

        commonAssert(head, n, output);
    }

    public void commonAssert(int[] head, int n, int[] output) {
        // WHEN
        ListNode listNode = ListNode.array2ListNode(head);
        int[] actual = ListNode.listNode2Array(new Solution().removeNthFromEnd(listNode, n));

        // THEN
        assertArrayEquals(output, actual);
    }
}
