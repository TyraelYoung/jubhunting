package wang.tyrael.leetcode.geometry.pointsonaline;

import java.util.*;

/**
 * @author: wangchao
 * 2018/6/8 0008
 */
public class Solution {
    public int maxPoints(Point[] points) {
        System.out.println("maxPoints:" + points.length);
        if (points.length < 2){
            return points.length;
        }
        //锚定一个点计算斜率
        int max =Integer.MIN_VALUE;
        for (int i = 0; i < points.length-1; i++) {
            Map<Fraction, Integer> count = new HashMap<>();
            int countSame = 0;
            for (int j = i+1; j < points.length; j++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y){
                    countSame ++;
                }else{
                    Fraction slope = new Line(points[i], points[j]).computeSlope();
                    count.put(slope, count.getOrDefault(slope, 1) + 1);
                }
            }
            //记录最大
            int thisMax;
            if (count.isEmpty()){
                thisMax = countSame +1;
            }else{
                thisMax = count.values().stream().max((a, b) -> a-b).get();
                thisMax += countSame;
            }
            if (thisMax > max){
                max = thisMax;
            }
        }
        return max;
    }


    public static long gcd(long a, long b) {
        /*
         * The reason we require both arguments to be >= 0 is because otherwise, what do you return on
         * gcd(0, Long.MIN_VALUE)? BigInteger.gcd would return positive 2^63, but positive 2^63 isn't an
         * int.
         */

        if (a == 0) {
            // 0 % b == 0, so b divides a, but the converse doesn't hold.
            // BigInteger.gcd is consistent with this decision.
            return b;
        } else if (b == 0) {
            return a; // similar logic
        }
        /*
         * Uses the binary GCD algorithm; see http://en.wikipedia.org/wiki/Binary_GCD_algorithm. This is
         * >60% faster than the Euclidean algorithm in benchmarks.
         */
        int aTwos = Long.numberOfTrailingZeros(a);
        a >>= aTwos; // divide out all 2s
        int bTwos = Long.numberOfTrailingZeros(b);
        b >>= bTwos; // divide out all 2s
        while (a != b) { // both a, b are odd
            // The key to the binary GCD algorithm is as follows:
            // Both a and b are odd. Assume a > b; then gcd(a - b, b) = gcd(a, b).
            // But in gcd(a - b, b), a - b is even and b is odd, so we can divide out powers of two.

            // We bend over backwards to avoid branching, adapting a technique from
            // http://graphics.stanford.edu/~seander/bithacks.html#IntegerMinOrMax

            long delta = a - b; // can't overflow, since a and b are nonnegative

            long minDeltaOrZero = delta & (delta >> (Long.SIZE - 1));
            // equivalent to Math.min(delta, 0)

            a = delta - minDeltaOrZero - minDeltaOrZero; // sets a to Math.abs(a - b)
            // a is now nonnegative and even

            b += minDeltaOrZero; // sets b to min(old a, b)
            a >>= Long.numberOfTrailingZeros(a); // divide out all 2s, since 2 doesn't divide b
        }
        return a << Math.min(aTwos, bTwos);
    }

    public class Tuple<X, Y> {
        public X x;
        public Y y;

        public Tuple() {
        }

        public Tuple(X a, Y b) {
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
            if (obj instanceof Tuple){
                Tuple b = (Tuple) obj;
                return x.equals(b.x) && y.equals(b.y);
            }else{
                return false;
            }
        }
    }

    public class Fraction extends Tuple<Long, Long> {
        public Fraction() {
        }

        public Fraction(Long a, Long b) {
            super(a, b);
        }

        public void reduce(){
            if (x==0){
                //标准化无穷
//                y = y > 0? 1L:-1L;
                y = 1L;
                return;
            }
            //注意越界
            long gcd = gcd(Math.abs(x), Math.abs(y));
            x = x / gcd;
            y = y / gcd;
            normalizeSign();
            return ;
        }

        /**
         * 符号标准化
         */
        public void normalizeSign(){
            int sign;
            if (x == 0){
                sign = y>=0?1:-1;
            }else{
                sign = (x > 0 & y> 0) | (x<0 & y<0) ? 1:-1;
            }
            x = Math.abs(x);
            y = sign * Math.abs(y);
        }
    }

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
}


