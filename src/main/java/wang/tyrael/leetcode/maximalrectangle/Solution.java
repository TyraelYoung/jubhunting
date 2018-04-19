package wang.tyrael.leetcode.maximalrectangle;

import wang.tyrael.basic.Point;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangchao
 * 2018/4/18 0018
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int height = matrix.length;
        if (height == 0){
            return 0;
        }
        int width = matrix[0].length;
        if (width == 0){
            return 0;
        }
        int unitHeight[][] = new int[width][width];
        for (int row = 0; row < height; row++) {
            for (int i = 0; i < width; i++) {

            }
        }
        return 0;
    }
}
