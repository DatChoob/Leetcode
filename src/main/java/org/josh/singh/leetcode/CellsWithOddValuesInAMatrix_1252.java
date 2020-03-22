package org.josh.singh.leetcode;

/**
 * Given n and m which are the dimensions of a matrix initialized by zeros and given an array indices where indices[i] = [ri, ci]. For each pair of [ri, ci] you have to increment all cells in row ri and column ci by 1.
 * Return the number of cells with odd values in the matrix after applying the increment to all indices.
 * <p>
 * Example 1:
 * Input: n = 2, m = 3, indices = [[0,1],[1,1]]
 * Output: 6
 * Explanation: Initial matrix = [[0,0,0],[0,0,0]].
 * After applying first increment it becomes [[1,2,1],[0,1,0]].
 * The final matrix will be [[1,3,1],[1,3,1]] which contains 6 odd numbers.
 * <p>
 * Example 2:
 * Input: n = 2, m = 2, indices = [[1,1],[0,0]]
 * Output: 0
 * Explanation: Final matrix = [[2,2],[2,2]]. There is no odd number in the final matrix.
 * <p>
 * <p>
 * Constraints:
 * 1 <= n <= 50
 * 1 <= m <= 50
 * 1 <= indices.length <= 100
 * 0 <= indices[i][0] < n
 * 0 <= indices[i][1] < m
 */
public class CellsWithOddValuesInAMatrix_1252 {
    //Your runtime beats 85.82 % of java submissions.
    public int oddCells(int n, int m, int[][] indices) {

        int[][] cells = new int[n][m];
        for (int[] index : indices) {
            int row = index[0];
            int col = index[1];
            incrementRow(row, cells);
            incrementColumn(col, cells);
        }
        int sum = 0;
        for (int[] row : cells) {
            for (int cell : row) {
                if (cell % 2 == 1) {
                    sum++;
                }
            }
        }
        return sum;
    }

    private void incrementRow(int rowNum, int[][] cells) {
        int[] column = cells[rowNum];
        for (int i = 0; i < column.length; i++) {
            column[i] = column[i] + 1;
        }
    }

    private void incrementColumn(int columnNum, int[][] cells) {
        for (int i = 0; i < cells.length; i++) {
            cells[i][columnNum] = cells[i][columnNum] + 1;
        }
    }
}
