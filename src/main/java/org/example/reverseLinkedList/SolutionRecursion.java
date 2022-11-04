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
public class SolutionRecursion {
    public ListNode reverseList(ListNode head) {
        return recursion(null, head);
    }

    private ListNode recursion(ListNode prev, ListNode cur) {
        if (cur == null) {
            return prev;
        }

        ListNode temp = null;
        temp = cur.next;
        cur.next = prev;

        return recursion(cur, temp);
    }
}
