package org.example.intersectionOfTwoLinkedLists;

import org.example.lib.ListNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SolutionTest {
    @Test
    public void example() {
        commonAssert(8, new int[]{4, 1, 8, 4, 5}, new int[]{5, 6, 1, 8, 4, 5}, 2, 3);
        commonAssert(2, new int[]{1, 9, 1, 2, 4}, new int[]{3, 2, 4}, 3, 1);
        commonAssert(0, new int[]{2, 6, 4}, new int[]{1, 5}, 3, 2);
    }

    private void commonAssert(int val, int listA[], int listB[], int skipA, int skipB) {
        // GIVEN
        ListNode listNodeA = ListNode.array2ListNode(listA);
        ListNode skipANode = listNodeA.getAfter(skipA);

        ListNode skipBList = ListNode.array2ListNode(Arrays.stream(listB).boxed()
                .collect(Collectors.toList())
                .subList(0, skipB)
                .stream().mapToInt(Integer::intValue).toArray());
        skipBList.getAfter(skipB - 1).next = skipANode;

        // WHEN
        ListNode intersectionNode = new Solution().getIntersectionNode(listNodeA, skipBList);

        // THEN
        assertEquals(skipANode, intersectionNode);
        if (val != 0) {
            assertEquals(val, intersectionNode.val);
        } else {
            assertNull(intersectionNode);
        }
    }
}
