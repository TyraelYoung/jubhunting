package wang.tyrael.leetcode.longestincreasing;

import java.util.Arrays;

/**
 * @author: wangchao
 */
public class Solution {
    public int[][] cache;

    int[][] matrix;
    int height, width;

    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
         height = matrix.length;
         if (height == 0){
             return 0;
         }
         width = matrix[0].length;
         if(width == 0){
             return 0;
         }

        cache = new int[height][];
        for (int i = 0; i < height; i++) {
            cache[i] = new int[width];
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                go(i,j);
            }
        }

        int max = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (cache[i][j] > max ){
                    max = cache[i][j];
                }
            }
        }
        return max;
    }

    public int go(int i, int j){
        if(cache[i][j] != 0){
            return cache[i][j];
        }
        int[] d = new int[4];
        //up
        if(i-1 >= 0 && matrix[i-1][j] > matrix[i][j]){
            d[0] = go(i-1, j);
        }
        //left
        if(j-1 >= 0 && matrix[i][j-1] > matrix[i][j]){
            d[1] = go(i, j-1);
        }
        //down
        if(i +1 < height && matrix[i+1][j] > matrix[i][j]){
            d[2] = go(i+1, j);
        }
        //right
        if(j+1 < width && matrix[i][j+1] > matrix[i][j]){
            d[3] = go(i, j+1);
        }
        Arrays.sort(d);
        cache[i][j] = d[3] + 1;
        return cache[i][j];
    }

}
