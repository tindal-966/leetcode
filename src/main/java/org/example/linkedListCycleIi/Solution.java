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
public class Solution {

    /**
     * @return the node where the cycle begins. If there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();

        ListNode cur = head;
        while (cur != null) {
            if (map.containsKey(cur)) {
                return cur;
            }

            map.put(cur, 0);
            cur = cur.next;
        }

        return null;
    }
}
