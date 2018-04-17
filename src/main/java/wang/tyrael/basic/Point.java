package wang.tyrael.basic;

/**
 * @author: wangchao
 * 2018/4/17 0017
 */
public class Point {
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
}
