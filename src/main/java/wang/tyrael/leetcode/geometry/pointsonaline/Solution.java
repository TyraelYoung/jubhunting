package wang.tyrael.leetcode.geometry.pointsonaline;

import wang.tyrael.basic.DoubleStatic;
import wang.tyrael.basic.Line;
import wang.tyrael.basic.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static wang.tyrael.basic.DoubleStatic.equal;

/**
 * @author: wangchao
 * 2018/6/8 0008
 */
public class Solution {
    public int maxPoints(Point[] points) {
        System.out.println("maxPoints:" + points.length);
        if (points.length < 2){
            return 0;
        }
        //锚定一个点计算斜率
        int[] countOnLine = new int[points.length-1];
        for (int i = 0; i < points.length-1; i++) {
            double slope = new Line(points[i], points[i+1]).computeSlope();
            countOnLine[i] = 2;
            for (int j = i+2; j < points.length; j++) {
                double slopeNext = new Line(points[i], points[j]).computeSlope();
                if (equal(slope, slopeNext)){
                    //斜率相等在一条线上
                    countOnLine[i] ++;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < points.length-1; i++) {
            if (max < countOnLine[i])
                max = countOnLine[i];
        }
        return max;
    }
}


