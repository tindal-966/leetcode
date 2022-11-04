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
        ListNode dummyNode = new ListNode(-1, head); // 使用 dummyNode 可以忽视头两个互换和后续互换的不同（后续互换 [n, n+1] 需要考虑 n-1 的 next 问题）

        ListNode cursor = dummyNode;
        while (cursor != null) {
            ListNode next = cursor.next;
            if (next == null) {
                break;
            }

            ListNode next2 = next.next;
            if (next2 != null) {
                cursor.next = next2;

                ListNode temp = next2.next;
                next2.next = next;
                next.next = temp;
            }
            cursor = next;
        }

        return dummyNode.next;
    }
}
