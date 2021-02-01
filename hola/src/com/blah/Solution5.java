package com.blah;

public class Solution5 {
    public static int orignalColor;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        orignalColor = image[sr][sc];
        return recursiveFill(image, sr, sc, newColor);
    }

    public int[][] recursiveFill(int[][] image, int sr, int sc, int newColor) {
        int rowLength = image.length;
        int coloumnLength = image[sr].length;
        if (image[sr][sc] == orignalColor) {
            image[sr][sc] = newColor;

            if (sr + 1 < rowLength) {
                if (image[sr + 1][sc] == orignalColor) {
                    recursiveFill(image, sr + 1, sc, newColor);
                }
            }
            if (sc + 1 < coloumnLength) {
                if (image[sr][sc + 1] == orignalColor) {
                    recursiveFill(image, sr, sc + 1, newColor);
                }
            }
            if (sr - 1 >= 0) {
                if (image[sr - 1][sc] == orignalColor) {
                    recursiveFill(image, sr - 1, sc, newColor);
                }
            }
            if (sc - 1 >= 0) {
                if (image[sr][sc - 1] == orignalColor) {
                    recursiveFill(image, sr, sc - 1, newColor);
                }
            }
        }

        return image;

    }

}
