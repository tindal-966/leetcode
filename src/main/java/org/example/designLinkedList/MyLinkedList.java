package org.example.designLinkedList;

class MyLinkedList {
    public int val;
    public MyLinkedList next;
    public MyLinkedList prev;

    public MyLinkedList() {
        val = -1; // unConstructNode
    }

    public int get(int index) { // todo MyLinkedList t = new MyLinkedList(); t.get(0) == -1 ??
        MyLinkedList p = this;
        while (p != null && index > 0) {
            p = p.next;
            index--;
        }

        return (index == 0 && p != null)? p.val: -1;
    }

    public void addAtHead(int val) {
        if (this.val == -1) {
            this.val = val;
            return;
        }

        MyLinkedList p = this;
        while (p.prev != null) {
            p = p.prev;
        }

        MyLinkedList newHead = new MyLinkedList();
        newHead.val = val;
        newHead.prev = null;
        newHead.next = p;
        p.prev = newHead;
    }

    public void addAtTail(int val) {
        if (this.val == -1) {
            this.val = val;
            return;
        }

        MyLinkedList p = this;
        while (p.next != null) {
            p = p.next;
        }

        MyLinkedList newTail = new MyLinkedList();
        newTail.val = val;
        newTail.prev = p;
        newTail.next = null;
        p.next = newTail;
    }

    public void addAtIndex(int index, int val) { // 如果 index == length, 等同于 addAtTail
        MyLinkedList p = this;

        // find index-1
        int pi = 0;
        for (; pi < index - 1 && p != null; pi++) {
            p = p.next;
        }

        if (p == null) return; // invalid index

        MyLinkedList newNode = new MyLinkedList();
        newNode.val = val;
        newNode.next = p.next;
        newNode.prev = p;
        p.next = newNode;
    }

    public void deleteAtIndex(int index) { // todo MyLinkedList t = new MyLinkedList(); t.addAtHead(1); t.deleteAtIndex(0); NOW t == null?? OR t.val == -1??
        MyLinkedList p = this;
        while (p != null && index > 0) {
            p = p.next;
            index--;
        }

        if (index != 0 || p == null) return; // index >= length

        if (p.next != null) p.next.prev = p.prev;
        if (p.prev != null) p.prev.next = p.next;

        if (p.next == null && p.prev == null) {
            p.val = -1;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
