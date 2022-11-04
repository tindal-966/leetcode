package org.example.designLinkedList;

class MyLinkedList {
    static class Node {
        public int val;
        public Node next;
        public Node prev;

        Node() {
            this.val = -1;
        }
        Node(int val) {
            this.val = val;
        }
        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
        Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    private final Node dummyHead;
    private int size;
    public MyLinkedList() {
        dummyHead = new Node(-1);
        size = 0;
    }

    public int get(int index) {
        Node node = getNode(index);

        return node == null? -1: node.val;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        node.prev = dummyHead;
        node.next = dummyHead.next;

        if (dummyHead.next != null) {
            dummyHead.next.prev = node;
        }
        dummyHead.next = node;

        size++;
    }

    public void addAtTail(int val) {
        Node p = dummyHead;
        while (p.next != null) {
            p = p.next;
        }

        Node node = new Node(val);
        node.prev = p;
        p.next = node;

        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list.
     */
    public void addAtIndex(int index, int val) { // WHEN index == length, EQUAL addAtTail
        if (index > size) {
            return;
        }

        Node p = dummyHead;
        while (index-- > 0) {
            p = p.next;
        }

        Node node = new Node(val);
        node.prev = p;
        node.next = p.next;
        if (node.next != null) {
            node.next.prev = node;
        }
        p.next = node;

        size++;
    }

    public void deleteAtIndex(int index) {
        Node node = getNode(index);
        if (node == null) return;

        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }

        size--;
    }

    private Node getNode(int index) {
        if (index > size - 1) { // dummyHead
            return null;
        }

        Node p = dummyHead.next;
        while (index-- > 0) {
            p = p.next;
        }

        return p;
    }

    public int getSize() {
        return size;
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
