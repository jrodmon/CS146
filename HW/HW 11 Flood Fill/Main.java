package org.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1;
        int sc = 1;
        int color = 2;
        System.out.println(Arrays.deepToString(floodFill(image, sr, sc, color)));
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0 || image[0].length == 0){
            return image;
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[image.length][image[0].length];
        int initialColor = image[sr][sc];
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        if (initialColor == color){
            return image;
        }

        queue.offer(new int[]{sr,sc});
        visited[sr][sc] = true;

        while(!queue.isEmpty()) {
            int[] currentPixel = queue.poll();
            int row = currentPixel[0];
            int col = currentPixel[1];
            image[row][col] = color;

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if(newRow >= 0 && newRow < image.length && newCol >= 0 && newCol < image[0].length
                && !visited[newRow][newCol] && image[newRow][newCol] == initialColor) {
                    queue.offer(new int[]{newRow,newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }

        return image;
    }


}
