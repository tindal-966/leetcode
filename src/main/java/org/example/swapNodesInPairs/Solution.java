package org.example.swapNodesInPairs;

import org.example.lib.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1, head); // 使用 dummyHead 可以忽视头两个互换和后续互换的不同（后续互换 [n, n+1] 需要考虑 n-1 的 next 问题）

        ListNode cursor = dummyHead;
        while (cursor.next != null && cursor.next.next != null) {
            ListNode next = cursor.next;
            ListNode next2 = cursor.next.next;

            // set [n-1]
            cursor.next = next2;
            // swap [n, n+1]
            ListNode temp = next2.next;
            next2.next = next;
            next.next = temp;

            cursor = cursor.next.next;
        }

        return dummyHead.next;
    }
}
