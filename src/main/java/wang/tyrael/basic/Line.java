package wang.tyrael.basic;

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

    public double computeSlope(){
        if (b.x == a.x){
            return Double.MAX_VALUE;
        }
        return (b.y - a.y)/(double)(b.x-a.x);
    }
}
