package org.example.removeNthNodeFromEndOfList;

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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1, head);

        ListNode fastCur = dummyHead;
        ListNode slowCur = dummyHead;
        int count = 0;

        while (fastCur.next != null) {
            fastCur = fastCur.next;

            if (count != n) {
                count++;
            } else {
                slowCur = slowCur.next;
            }
        }

        if (count == n && slowCur.next != null) {
            slowCur.next = slowCur.next.next;
        }

        return dummyHead.next;
    }
}
