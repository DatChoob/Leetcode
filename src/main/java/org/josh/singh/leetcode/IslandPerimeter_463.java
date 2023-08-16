package org.josh.singh.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
 * <p>
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 * <p>
 * The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 */
public class IslandPerimeter_463 {

    //    16ms
//    Beats 7.08%of users with Java
//
//    44.46mb
//    Beats 23.88%of users with Java
    public int islandPerimeter(int[][] grid) {
        record Point(int x, int y) {
        }


        int firstX = 0;
        int firstY = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    firstX = i;
                    firstY = j;
                    break;
                }
            }
        }
        int sum = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(firstX, firstY));

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (visited[p.x][p.y]) continue;
            visited[p.x][p.y] = true;
            //left side
            if (p.x - 1 < 0 || grid[p.x - 1][p.y] == 0) {
                sum++;
            } else {
                queue.add(new Point(p.x - 1, p.y));
            }
            //right
            if (p.x + 1 >= grid.length || grid[p.x + 1][p.y] == 0) {
                sum++;
            } else {
                queue.add(new Point(p.x + 1, p.y));
            }

            //top
            if (p.y - 1 < 0 || grid[p.x][p.y - 1] == 0) {
                sum++;
            } else {
                queue.add(new Point(p.x, p.y - 1));
            }
            //bottom
            if (p.y + 1 >= grid[p.x].length || grid[p.x][p.y + 1] == 0) {
                sum++;
            } else {
                queue.add(new Point(p.x, p.y + 1));
            }


        }
        return sum;

    }

    public static void main(String[] args) {
        System.out.println(new IslandPerimeter_463().islandPerimeter(new int[][]{{1, 1}}));
    }
}

