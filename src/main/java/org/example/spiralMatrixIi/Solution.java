// Source : https://leetcode.com/problems/spiral-matrix-ii/
// Author : tindal-966
// Date   : 2022-08-29

/*****************************************************************************************************
 *
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n^2 in spiral
 * order.
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 *
 * Example 2:
 *
 * Input: n = 1
 * Output: [[1]]
 *
 * Constraints:
 *
 * 	1 <= n <= 20
 ******************************************************************************************************/
package org.example.spiralMatrixIi;

/**
 * Assume matrix is:
 *  1,  2,  3,  4,  5,
 * 16, 17, 18, 19,  6,
 * 15, 24, 25, 20,  7,
 * 14, 23, 22, 21,  8,
 * 13, 12, 11, 10,  9
 *
 * Notes:
 * 1. if one circle is a layer, it has *(n+1)/2* layer, num 25 is a special layer
 * 2. if every direction in circle we only handle *n - layer * 2 - 1*(first layer is 0) nums, the handle times every direction is the same
 *      layer 0: 4. first 1,2,3,4; second 5,6,7,8; third 9,10,11,12
 *      layer 1: 2
 *      layer 2: 0, special handle
 * 3. every direction first number's coordination(also is corner in circle)
 *      top-left [layer, layer]
 *      top-right [layer, n - 1 - layer]
 *      bottom-right [n - 1 - layer, n - 1 - layer]
 *      bottom-left [n - 1 - layer, layer]
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        int currentValue = 1, totalLayer = (n + 1) / 2;
        for (int layer = 0; layer < totalLayer; layer++) {
            int count = n - layer * 2 - 1; // handle times in every direction

            if (count == 0) { // the last layer which has odd layer, special handle
                result[layer][layer] = currentValue;
                break;
            }

            for (int j = 0; j < count; j++) {
                result[layer][layer + j] = currentValue++;
            }
            for (int j = 0; j < count; j++) {
                result[layer + j][n - 1 - layer] = currentValue++;
            }
            for (int j = 0; j < count; j++) {
                result[n - 1 - layer][n - 1 - layer - j] = currentValue++;
            }
            for (int j = 0; j < count; j++) {
                result[n - 1 - layer - j][layer] = currentValue++;
            }
        }

        return result;
    }
}


