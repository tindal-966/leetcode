package org.example.lib;

import static org.junit.Assert.*;
import org.junit.Test;

public class ListNodeTest {
    ListNode listNode = ListNode.array2ListNode(new int[]{0, 1, 2, 3, 4});

    @Test
    public void getAfterTest() {
        // GIVEN
        // WHEN
        // THEN
        assertNull(listNode.getAfter(-1));

        assertNull(listNode.getAfter(5));
        assertNull(listNode.getAfter(6));

        assertEquals(listNode, listNode.getAfter(0));
        assertEquals(listNode.next, listNode.getAfter(1));
        assertEquals(listNode.getAfter(1).next, listNode.getAfter(2));
        assertEquals(listNode.getAfter(2).next, listNode.getAfter(3));
        assertEquals(listNode.getAfter(3).next, listNode.getAfter(4));
    }

}
