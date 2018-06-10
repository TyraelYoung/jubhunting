package wang.tyrael.basic.math;

import wang.tyrael.basic.geometry.Point;

public class MathStatic {
    public static int gcdPositive(int x, int y){
        if (x == 0 || y == 0){
            return 1;
        }
        if ((x & 1) == 0 && (y & 1) == 0){
            return 2*gcdPositive(x>>2, y >>2);
        }
        if (x < y){
            return gcdPositive(y-x, x);
        }else if (y < x){
            return gcdPositive(x-y, y);
        }
        return x;
    }

    public static long gcdPositive(long x, long y){
        if (x == 0 || y == 0){
            return 1;
        }
        if ((x & 1) == 0 && (y & 1) == 0){
            return 2*gcdPositive(x>>2, y >>2);
        }
        if (x < y){
            return gcdPositive(y-x, x);
        }else if (y < x){
            return gcdPositive(x-y, y);
        }
        return x;
    }
}
