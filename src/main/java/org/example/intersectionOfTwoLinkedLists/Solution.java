package org.example.intersectionOfTwoLinkedLists;

import org.example.lib.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * NOTE:
     * 1. "EQUAL" mean two node in point/reference is consistent, not in Node.val
     * 2. If the two lists intersect, the intersection will be "in the end of list" and "have the same length"
     *
     * Follow up:
     * 1. O(m + n) time and use only O(1) memory
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA); // O(m)
        int lenB = getLength(headB); // O(n)

        ListNode longListNode = headA;
        ListNode shortListNode = headB;
        if (lenA < lenB) {
            longListNode = headB;
            shortListNode = headA;
        }

        int skipLength = lenA - lenB < 0? lenB - lenA: lenA - lenB;
        ListNode cur = longListNode;
        while (skipLength-- > 0) { // O(abs(m-n))
            cur = cur.next;
        }

        ListNode shortCur = shortListNode;
        while (cur != null) { // O(max(m, n) - abs(m-n))
            if (shortCur == cur) {
                return cur;
            }

            shortCur = shortCur.next;
            cur = cur.next;
        }

        return null; // total time: m>n, O(m+n+m-n+m-(m-n))=O(2m+n); m<n, O(m+n+n-m+n-(n-m))=O(2n+m)
    }

    public int getLength(ListNode listNode) {
        int length = 0;

        ListNode cur = listNode;
        while (cur != null) {
            length++;
            cur = cur.next;
        }

        return length;
    }
}
