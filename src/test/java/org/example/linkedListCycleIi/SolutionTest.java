package org.example.linkedListCycleIi;

import org.example.lib.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void example() {
        commonAssert(new int[]{3, 2, 0, -4}, 1);
        commonAssert(new int[]{1, 2}, 0);
        commonAssert(new int[]{1}, -1);
    }

    private void commonAssert(int[] head, int pos) {
        // GIVEN
        ListNode listNode = ListNode.array2ListNode(head);
        ListNode tail = listNode.getAfter(head.length - 1);
        ListNode posNode = (pos >= 0 ? listNode.getAfter(pos) : null);

        tail.next = posNode;

        // WHEN
        ListNode result = new Solution().detectCycle(listNode);

        // THEN
        assertEquals(posNode, result);
    }
}
