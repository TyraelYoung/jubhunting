package wang.tyrael.basic.math;

/**
 * @Auther: wangchao
 * @Date: 2018/7/12 18:33
 * @Description:
 */
public class MathStatic {
    public int gcd(int a, int b) {
        if (a < 0 || b < 0) throw new RuntimeException("不支持负数");
        if (a < b) return gcd(b, a);
        if (b == 0) return a;
        if (a % 2 == 0) {
            if (b % 2 == 0) return gcd(a >> 2, b >> 2) << 2;
            else return gcd(a >> 2, b);
        } else {
            if (b % 2 == 0) return gcd(a, b >> 2);
            else return gcd(a - b, b);
        }
    }
}
