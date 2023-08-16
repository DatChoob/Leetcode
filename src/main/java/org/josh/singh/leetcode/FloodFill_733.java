package org.josh.singh.leetcode;

/**
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 * <p>
 * You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
 * <p>
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.
 * <p>
 * Return the modified image after performing the flood fill.
 */
public class FloodFill_733 {

    //Beats 100.00%of users with Java
    //43.93mb
    //Beats 78.63%of users with Java
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        dfs(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    private void dfs(int[][] image, int x, int y, int color, int colorToChange) {
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length ||
                image[x][y] == color || image[x][y] != colorToChange) {
            return;
        }
        image[x][y] = color;

        dfs(image, x - 1, y, color, colorToChange);
        dfs(image, x + 1, y, color, colorToChange);
        dfs(image, x, y - 1, color, colorToChange);
        dfs(image, x, y + 1, color, colorToChange);

    }
}
