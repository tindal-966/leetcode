package org.example.removeLinkedListElements;

import org.example.lib.ListNode;

class SolutionDummyHead {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0, head);

        ListNode p = dummyHead;
        while (p != null && p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }

        return dummyHead.next;
    }
}
