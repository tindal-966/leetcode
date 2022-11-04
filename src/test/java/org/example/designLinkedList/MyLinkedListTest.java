package org.example.designLinkedList;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MyLinkedListTest {
    @Test
    public void example1() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);

        myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
        Assert.assertArrayEquals(new int[]{1, 2, 3}, myLinkedList2Array(myLinkedList));

        Assert.assertEquals(2, myLinkedList.get(1));              // return 2

        myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
        Assert.assertArrayEquals(new int[]{1, 3}, myLinkedList2Array(myLinkedList));

        Assert.assertEquals(3, myLinkedList.get(1));              // return 3

    }

    /**
     * ["MyLinkedList","addAtHead","deleteAtIndex"]
     * [[],[1],[0]]
     */
    @Test
    public void e1() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.deleteAtIndex(0);

        assertArrayEquals(new int[]{}, myLinkedList2Array(myLinkedList));
    }

    /**
     * Input
     * ["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
     * [[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]
     * Output
     * [null,null,null,null,null,null,null,null,-1,null,null,null]
     * Expected
     * [null,null,null,null,null,null,null,null,4,null,null,null]
     */
    @Test
    public void e2() {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(7);
        list.addAtHead(2);
        list.addAtHead(1);
        list.addAtIndex(3, 0);
        list.deleteAtIndex(2);
        list.addAtHead(6);
        list.addAtTail(4);
        assertEquals(4, list.get(4));
        list.addAtHead(4);
        list.addAtIndex(5, 0);
        list.addAtHead(6);
    }

    public static int[] myLinkedList2Array(MyLinkedList linkedList) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < linkedList.getSize(); i++) {
            result.add(linkedList.get(i));
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
