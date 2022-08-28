package org.example.removeElement;

/**
 * Two pivot traverse array with different direction.
 *
 * Pros:
 * 1. reduce the number of element be moved
 *
 * 0 ms	42.2 MB
 */
public class SolutionTwoWayPivot {
    public int removeElement(int[] nums, int val) {
        int forwardPivot = 0, reversePivot = nums.length - 1;

        while (forwardPivot <= reversePivot) {
            if (nums[forwardPivot] != val) {
                forwardPivot++;
            } else if (nums[reversePivot] == val) {
                reversePivot--;
            } else { // nums[forwardPivot] == val && nums[reversePivot] != val
                nums[forwardPivot++] = nums[reversePivot--];
            }
        }

        return forwardPivot;
    }
}
