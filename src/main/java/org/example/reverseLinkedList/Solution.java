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
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newDummyHead = new ListNode();
        boolean firstTime = true;

        ListNode p = head;
        while (p != null) {
            if (firstTime) {
                newDummyHead.next = new ListNode(p.val);
                firstTime = false;
            } else {
                ListNode temp = newDummyHead.next;
                ListNode newNode = new ListNode(p.val, p.next);

                newDummyHead.next = newNode;
                newNode.next = temp;
            }

            p = p.next;
        }

        return newDummyHead.next;
    }
}
