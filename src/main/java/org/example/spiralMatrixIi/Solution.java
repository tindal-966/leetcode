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

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] a = new int[n][n];

        int direction = 0; // 0: right; 1: down; 2: left; 3: up;
        int[] directionWithStep = {n, n - 1, n - 1, n - 2};
        int currentStep = 0;
        int size = n * n;
        int row = 0, column = 0;
        for (int i = 1; i <= size; i++) {
            if (currentStep == directionWithStep[direction % 4] || directionWithStep[direction % 4] < 0) {
                if ((direction / 4) != ((direction + 1) / 4)) { // second time to right, re-calculate the step
                    calStep(directionWithStep);
                }
                direction += 1;
                if (direction % 4 == 0) {
                    column++;
                    row++; // because first row--, so rollback
                } else if (direction % 4 == 1) {
                    row++;
                    column--;
                } else if (direction % 4 == 2) {
                    column--;
                    row--;
                } else {
                    row--;
                    column++;
                }
                currentStep = 0;
            }

            a[row][column] = i;

            // how move when direction
            if (direction % 4 == 0) {
                column++;
            } else if (direction % 4 == 1) {
                row++;
            } else if (direction % 4 == 2) {
                column--;
            } else {
                row--;
            }

            currentStep++;
        }

        return a;
    }

    public void calStep(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] -= 2;
        }
    }
}


