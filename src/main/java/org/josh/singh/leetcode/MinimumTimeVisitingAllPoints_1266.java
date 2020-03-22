package org.josh.singh.leetcode;

/**
 * On a plane there are n points with integer coordinates points[i] = [xi, yi]. Your task is to find the minimum time in seconds to visit all points.
 * <p>
 * You can move according to the next rules:
 * In one second always you can either move vertically, horizontally by one unit or diagonally (it means to move one unit vertically and one unit horizontally in one second).
 * You have to visit the points in the same order as they appear in the array.
 * <p>
 * <p>
 * Example 1:
 * Input: points = [[1,1],[3,4],[-1,0]]
 * Output: 7
 * Explanation: One optimal path is [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]
 * Time from [1,1] to [3,4] = 3 seconds
 * Time from [3,4] to [-1,0] = 4 seconds
 * Total time = 7 seconds
 * <p>
 * Example 2:
 * Input: points = [[3,2],[-2,2]]
 * Output: 5
 * <p>
 * <p>
 * Constraints:
 * points.length == n
 * 1 <= n <= 100
 * points[i].length == 2
 * -1000 <= points[i][0], points[i][1] <= 1000
 */
public class MinimumTimeVisitingAllPoints_1266 {

    /**
     * Runtime: 12 ms, faster than 9.99% of Java online submissions for Minimum Time Visiting All Points.
     * Memory Usage: 39.3 MB, less than 100.00% of Java online submissions for Minimum Time Visiting All Points.
     */
    public int minTimeToVisitAllPoints(int[][] points) {
        int[] currentPoint = points[0];
        int moves = 0;
        for (int i = 1; i < points.length; i++) {
            int currentX = currentPoint[0];
            int currentY = currentPoint[1];

            int nextX = points[i][0];
            int nextY = points[i][1];

            do {
                int moveX = 0;
                if (nextX > currentX) {
                    moveX = 1;
                } else if (nextX < currentX) {
                    moveX = -1;
                }

                int moveY = 0;
                if (nextY > currentY) {
                    moveY = 1;
                } else if (nextY < currentY) {
                    moveY = -1;
                }
                currentX += moveX;
                currentY += moveY;

                moves++;
            } while (currentX != nextX || currentY != nextY);

            currentPoint = points[i];
        }
        return moves;
    }

    public int minTimeToVisitAllPoints_Math(int[][] points) {
        if (points == null || points.length < 2) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < points.length - 1; i++) {
            sum += distanceBetweenTwoPoints(points[i], points[i + 1]);
        }
        return sum;
    }

    private int distanceBetweenTwoPoints(int[] point, int[] point1) {
        int distanceX = Math.abs(point[0] - point1[0]);
        int distanceY = Math.abs(point[1] - point1[1]);
        int diagonal = Math.min(distanceX, distanceY);
        int horizontal = Math.abs(distanceX - distanceY);
        return diagonal + horizontal;

    }
}
