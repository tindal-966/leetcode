package org.example.lib;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * Base on this Node, get after index. If index = 0, return this
     */
    public ListNode getAfter(int index) {
        if (index < 0) {
            return null;
        }

        ListNode cur = this;
        while (index > 0 && cur != null) {
            cur = cur.next;
            index--;
        }

        return cur;
    }

    public static ListNode array2ListNode(int[] array) {
        int length = array.length;
        if (length == 0) return null;

        ListNode temp = null;
        for (int i = length - 1; i >= 0; i--) {
            temp = new ListNode(array[i], temp);
        }

        return temp;
    }

    public static int[] listNode2Array(ListNode listNode) {
        if (listNode == null) return new int[0];

        List<Integer> result = new ArrayList<>();
        while (listNode != null) {
            result.add(listNode.val);
            listNode = listNode.next;
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
