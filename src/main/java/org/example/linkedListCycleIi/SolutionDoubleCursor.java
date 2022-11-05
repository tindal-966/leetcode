package org.example.linkedListCycleIi;

import org.example.lib.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for singly-linked list.
 * class ListNode {
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
     * @return the node where the cycle begins. If there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fastCursor = head;
        ListNode slowCursor = head;

        while (fastCursor != null && fastCursor.next != null) {
            fastCursor = fastCursor.next.next;
            slowCursor = slowCursor.next;

            if (fastCursor == slowCursor) {
                ListNode headCursor = head;
                ListNode meetCursor = fastCursor;

                while (headCursor != meetCursor) {
                    headCursor = headCursor.next;
                    meetCursor = meetCursor.next;
                }

                return meetCursor;
            }
        }

        return null;
    }
}
