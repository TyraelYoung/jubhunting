package wang.tyrael.leetcode.geometry.pointsonaline;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangchao
 * 2018/4/17 0017
 */
public class Point {
    public static Point[] parsePoint(String s) {
        List<String> ls = JSON.parseArray(s, String.class);
        Point[] result = new Point[ls.size()];
        for (int i = 0; i < ls.size(); i++) {
            String item = ls.get(i);
            List<Integer> lo = JSON.parseArray(item, Integer.class);
            result[i] = new Point(lo.get(0), lo.get(1));
        }
        return result;
    }

    public static List<Point> toList(Point[] points){
        List<Point> list = new ArrayList<>();
        for (Point p :
                points) {
            list.add(p);
        }
        return list;
    }

    public int x;
    public int y;

    public Point() {
        x = 0;
        y = 0;
    }

    public Point(int a, int b) {
        x = a;
        y = b;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point){
            Point b = (Point) obj;
            return x == b.x && y == b.y;
        }else{
            return false;
        }
    }
}
