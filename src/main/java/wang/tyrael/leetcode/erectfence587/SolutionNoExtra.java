package wang.tyrael.leetcode.erectfence587;


import wang.tyrael.ArrayUtil;
import wang.tyrael.basic.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: wangchao
 * 2018/4/17 0017
 */
public class SolutionNoExtra {
    //Onlogn
    public List<Point> outerTrees(Point[] points) {
        List<Point> result = new ArrayList<>();
        if(points.length ==0){
            return result;
        }
        if(points.length <= 3){
            return toList(points);
        }
        if (handleX(points) > 0){
            return toList(points);
        }
        if (handleY(points) > 0){
            return toList(points);
        }

        return handle(points);
    }

    public List<Point> toList(Point[] points){
        List<Point> list = new ArrayList<>();
        for (Point p :
                points) {
            list.add(p);
        }
        return list;
    }

    public List<Point> handle(Point[] points){
//        List<Point> result = new ArrayList<>();

        List<Point> list = toList(points);
        Point start = removeStart(list);
        List<Point> sort = sortAndRemove(list, start);

        System.out.println();
        ArrayUtil.printPoint(sort);
        System.out.println();

        Stack<Point> stack = new Stack<>();
        stack.push(start);
        stack.push(sort.get(0));
        stack.push(sort.get(1));
        for (int i = 2; i < sort.size(); i++) {
            Point current = sort.get(i);
            Point top = stack.pop();
            Point nextTop = stack.peek();
            int ca = compareAngle(top, current, nextTop);
            while(ca < 0){
                top = stack.pop();
                nextTop = stack.peek();

                ca = compareAngle(top, current, nextTop);
            }

            stack.push(top);
            stack.push(current);

        }
        return stack;
    }

    /**
     * 按极角排序，
     * 如果平局，则保留最远点，删除其他。
     * @param list
     */
    public List<Point> sortAndRemove(List<Point> list, Point start){
        //类似插入排序
        List<Point> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Point p = list.get(i);
            //找到第一个比p大等的数
            int j;
            boolean flagFind = false;
            for (j = 0; j < result.size(); j++) {
                int c = compareAngle(p, result.get(j), start);
                if (c == 0) {
                    //找到一个等数
                    int cd = compareDistance(p, result.get(j), start);
                    if (cd > 0) {
                        //p比较远
                        result.set(j, p);
                    }
                    flagFind = true;
                    break;
                } else if (c > 0) {
                    //找到一个大数, p插前面
                    result.add(j, p);
                    flagFind = true;
                    break;
                }
            }
            if (! flagFind) {
                result.add(p);
            }
        }
        return result;
    }

    int compareDistance(Point a, Point b, Point start){
        int xa = a.x - start.x,
                ya = a.y - start.y,
                xb = b.x - start.x,
                yb = b.y - start.y;
        int powera = xa * xa + ya *ya,
                powerb = xb * xb + yb * yb;
        if(powera == powerb ){
            return 0;
        }else if (powera < powerb){
            return -1;
        }else{
            return 1;
        }
    }

    int compareAngle(Point a, Point b, Point start){
        int xa = a.x - start.x,
                ya = a.y - start.y,
                xb = b.x - start.x,
                yb = b.y - start.y;
        int xp = xa * yb - xb * ya;
        if (xp < 0){
            return -1;
        }else if (xp == 0){
            return 0;
        }else{
            return 1;
        }
    }

    /**
     * 找到y坐标最小的点
     * @param list
     * @return
     */
    public Point removeStart(List<Point> list){
        Point point = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Point current = list.get(i);
            if(current.y < point.y){
                point = current;
            }else if(current.y == point.y){
                if (current.x < point.x){
                    point = current;
                }
            }
        }
        list.remove(point);
        return point;
    }

    //On
    public int handleX(Point[] points){
        int miny = Integer.MAX_VALUE,
                maxy = Integer.MIN_VALUE;
        int x = points[0].x;
        for (Point p :
                points) {
            if (x == p.x){
                miny = miny < p.y? miny:p.y;
                maxy = maxy > p.y? maxy:p.y;
            }else{
                return -1;
            }
        }
        return maxy -miny;
    }

    //On
    public int handleY(Point[] points){
        int minx = Integer.MAX_VALUE,
                maxx = Integer.MIN_VALUE;
        int y = points[0].y;
        for (Point p :
                points) {
            if (y == p.y){
                minx = minx < p.x? minx:p.x;
                maxx = maxx > p.x? maxx:p.x;
            }else{
                return -1;
            }
        }
        return maxx -minx;
    }
}
