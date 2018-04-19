package wang.tyrael.leetcode.erectfence587;

import wang.tyrael.ArrayUtil;
import wang.tyrael.basic.Point;

import java.util.*;

public class Solution {
    public int orientation(Point p, Point q, Point r) {
        return (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
    }
    public int distance(Point p, Point q) {
        return (p.x - q.x) * (p.x - q.x) + (p.y - q.y) * (p.y - q.y);
    }
    private static Point bottomLeft(Point[] points) {
        Point bottomLeft = points[0];
        for (Point p: points)
            if (p.y < bottomLeft.y)
                bottomLeft = p;
        return bottomLeft;
    }
    public List< Point > outerTrees(Point[] points) {
        if (points.length <= 1)
            return Arrays.asList(points);
        Point bm = bottomLeft(points);
        Arrays.sort(points, new Comparator< Point >() {
            public int compare(Point p, Point q) {
                double diff = orientation(bm, p, q) - orientation(bm, q, p);
                if (diff == 0)
                    return distance(bm, p) - distance(bm, q);
                else
                    return diff > 0 ? 1 : -1;
            }
        });
        System.out.println("sort:");
        ArrayUtil.printPoint(Point.toList(points));

        int i = points.length - 1;
        while (i >= 0 && orientation(bm, points[points.length - 1], points[i]) == 0)
            i--;
        for (int l = i + 1, h = points.length - 1; l < h; l++, h--) {
            Point temp = points[l];
            points[l] = points[h];
            points[h] = temp;
        }
        System.out.println("swap:");
        ArrayUtil.printPoint(Point.toList(points));
        Stack< Point > stack = new Stack < > ();
        stack.push(points[0]);
        stack.push(points[1]);
        for (int j = 2; j < points.length; j++) {
            Point top = stack.pop();
            while (orientation(stack.peek(), top, points[j]) > 0)
                top = stack.pop();
            stack.push(top);
            stack.push(points[j]);
        }
        return new ArrayList< >(stack);
    }
}