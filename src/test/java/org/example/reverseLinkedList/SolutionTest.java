package org.example.reverseLinkedList;

import org.example.lib.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void example1() {
        // Given
        int[] ints = {1, 2, 3, 4, 5};
        int[] expected = {5, 4, 3, 2, 1};

        // When
        ListNode listNode = new Solution().reverseList(ListNode.array2ListNode(ints));

        // Then
        assertArrayEquals(expected, ListNode.listNode2Array(listNode));
    }

    @Test
    public void example2() {
        // Given
        int[] ints = {1, 2};
        int[] expected = {2, 1};

        // When
        ListNode listNode = new Solution().reverseList(ListNode.array2ListNode(ints));

        // Then
        assertArrayEquals(expected, ListNode.listNode2Array(listNode));
    }

    @Test
    public void example3() {
        // Given
        int[] ints = {};
        int[] expected = {};

        // When
        ListNode listNode = new Solution().reverseList(ListNode.array2ListNode(ints));

        // Then
        assertArrayEquals(expected, ListNode.listNode2Array(listNode));
    }
}
