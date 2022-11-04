package org.example.removeLinkedListElements;

import org.example.lib.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void middleAndAtLast() {
        // Given
        int[] ints = {1, 2, 6, 3, 4, 5, 6};

        ListNode listNode = ListNode.array2ListNode(ints);
        int val = 6;

        // When
        ListNode result = new Solution().removeElements(listNode, val);

        // Then
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, ListNode.listNode2Array(result));
    }

    @Test
    public void listNodeIsNull() {
        // Given
        int[] ints = {};

        ListNode listNode = ListNode.array2ListNode(ints);
        int val = 1;

        // When
        ListNode result = new Solution().removeElements(listNode, val);

        // Then
        Assert.assertArrayEquals(new int[]{}, ListNode.listNode2Array(result));
    }

    @Test
    public void head() {
        // Given
        int[] ints = {7, 7, 7, 7};

        ListNode listNode = ListNode.array2ListNode(ints);
        int val = 7;

        // When
        ListNode result = new Solution().removeElements(listNode, val);

        // Then
        Assert.assertArrayEquals(new int[]{}, ListNode.listNode2Array(result));
    }
}
