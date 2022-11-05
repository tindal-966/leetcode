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
public class SolutionDoubleCursor {
    /**
     * NOTE:
     * 1. "EQUAL" mean two node in point/reference is consistent, not in Node.val
     * 2. If the two lists intersect, the intersection will be "in the end of list" and "have the same length"
     *
     * Follow up:
     * 1. O(m + n) time and use only O(1) memory
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // IF intersect:
        //      listA + listB = skipA + intersect + skipB + intersect
        //      listB + listA = skipB + intersect + skipA + intersect
        // ELSE
        //      listA + listB = skipA + skipB
        //      listB + listA = skipB + skipA
        //
        // just check at last intersect whether consistent is OK

        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            curA = (curA != null? curA.next: headB);
            curB = (curB != null? curB.next: headA);
        }

        return curA;
    }
}
