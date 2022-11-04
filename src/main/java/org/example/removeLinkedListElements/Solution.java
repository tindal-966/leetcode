package org.example.removeLinkedListElements;

import org.example.lib.ListNode;

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // chang head if head.val == val
        while (head != null && head.val == val) {
            head = head.next;
        }

        // remove p in the linklist when p.val == val
        ListNode p = head;
        while (p != null && p.next != null) {
            if (p.next.val == val) { // // todo 为什么 “比下一个”？因为如果比当前的 val，假设符合，此时应该把当前的上一个的 next 设置为当前的下一个，此为单链表，获取不到当前的上一个
                p.next = p.next.next;
            } else { // todo 为什么 else 的情况下才移动？因为比较的是 “当前的下一个”，如果 “当前的下一个” 已经变化，还需要再比一次
                p = p.next;
            }
        }

        return head;
    }
}
