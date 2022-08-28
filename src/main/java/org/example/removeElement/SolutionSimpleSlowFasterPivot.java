package org.example.removeElement;

/**
 * Two pivot traverse array with different speed, but with the same direction 0~max.
 * **This solution is more like refilling this array**
 *
 * Compare with Solution:
 * 1. more simpler
 * 2. copy will happen in every element in the result arrays, even thought nums didn't has val, copy always happen
 *
 * 1 ms	42.2 MB
 */
public class SolutionSimpleSlowFasterPivot {
    public int removeElement(int[] nums, int val) {
        int slowPivot = 0;
        for (int fastPivot = 0; fastPivot < nums.length; fastPivot++) {
            if (nums[fastPivot] != val) {
                nums[slowPivot] = nums[fastPivot];
                slowPivot++;
            }
        }

        return slowPivot;
    }
}
