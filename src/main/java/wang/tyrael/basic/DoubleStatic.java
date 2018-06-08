package wang.tyrael.basic;

/**
 * @author: wangchao
 * 2018/6/8 0008
 */
public class DoubleStatic {
    public static boolean equal(double a, double b){
        //Double.MIN_VALUE是最小份额，再小就是0了。
        return Math.abs(a-b) < 2* Double.MIN_VALUE;
    }
}
