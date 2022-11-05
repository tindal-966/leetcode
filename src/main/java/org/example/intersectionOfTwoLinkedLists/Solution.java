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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) { // todo refactor
        int lenA = getLength(headA);
        int lenB = getLength(headB);

        ListNode longListNode = headA;
        ListNode shortListNode = headB;
        if (lenA < lenB) {
            longListNode = headB;
            shortListNode = headA;
        }

        int skipLength = lenA - lenB < 0? lenB - lenA: lenA - lenB;
        ListNode cur = longListNode;
        while (skipLength-- > 0) {
            cur = cur.next;
        }

        ListNode shorCur = shortListNode;
        ListNode intersectNode = null;
        while (cur != null) {
            if (shorCur != cur && intersectNode != null) {
                return null;
            }

            if (shorCur == cur && intersectNode == null) {
                intersectNode = cur;
            }

            shorCur = shorCur.next;
            cur = cur.next;
        }

        return intersectNode;
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
