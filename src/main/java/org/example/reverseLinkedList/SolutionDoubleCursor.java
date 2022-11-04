package org.example.reverseLinkedList;

import org.example.lib.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class SolutionDoubleCursor {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode beforeCur = null;

        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = beforeCur;

            beforeCur = cur;
            cur = temp;
        }

        return beforeCur;
    }
}
