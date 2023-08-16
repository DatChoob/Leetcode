package org.josh.singh.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
 * The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
 * The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
 */
public class PacificAtlanticWaterFlow_417 {

    record Point(int x, int y) {
    }

    //    12ms Beats 28.09%of users with Java
//    44.83mb Beats 56.30%of users with Java
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[][] pacificmemo = new boolean[heights.length][heights[0].length];
        boolean[][] atlanticmemo = new boolean[heights.length][heights[0].length];

        Stack<Point> pacificStack = new Stack<>();
        Stack<Point> atlanticStack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            pacificStack.push(new Point(i, 0));
            atlanticStack.push(new Point(i, heights[0].length - 1));
        }
        for (int i = 0; i < heights[0].length; i++) {
            pacificStack.push(new Point(0, i));
            atlanticStack.push(new Point(heights.length - 1, i));
        }

        dfs(heights, pacificmemo, pacificStack);
        dfs(heights, atlanticmemo, atlanticStack);
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                if (pacificmemo[i][j] && atlanticmemo[i][j]) {
                    list.add(List.of(i, j));
                }

            }
        }

        return list;
    }

    private void dfs(int[][] heights, boolean[][] memo, Stack<Point> stack) {
        int[][] dirs = new int[][]{
                {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };
        while (!stack.empty()) {
            Point p = stack.pop();
            if (memo[p.x][p.y]) continue;
            memo[p.x][p.y] = true;
            for (int[] dir : dirs) {
                int newX = p.x + dir[0];
                int newY = p.y + dir[1];
                if (newX >= 0 && newX < heights.length && newY >= 0 && newY < heights[0].length && !memo[newX][newY] && heights[newX][newY] >= heights[p.x][p.y]) {
                    stack.push(new Point(newX, newY));
                }
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(new PacificAtlanticWaterFlow_417().pacificAtlantic(new int[][]{
//                {1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}
//                {1}
                {1, 1}, {1, 1}, {1, 1}
        }));
    }
}
