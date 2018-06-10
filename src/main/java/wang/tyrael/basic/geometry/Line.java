package wang.tyrael.basic.geometry;

import wang.tyrael.basic.math.Fraction;

/**
 * @author: wangchao
 * 2018/6/8 0008
 */
public class Line {
    Point a;
    Point b;

    public Line(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    public Fraction computeSlope(){
        long x = b.x-a.x;
        long y = b.y -a.y;
        Fraction slope = new Fraction(x, y);
        slope.reduce();
        return slope;
    }
}
