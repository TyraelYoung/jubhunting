package wang.tyrael.leetcode.numberset.sameaverage805;

import java.util.*;

/**
 * 双向树搜索，中间匹配。
 *
 * 只考虑集合B和原集合A平均值是否相等即可。
 *
 * 从两个端选取集合B的值。
 *
 * @Auther: wangchao
 * @Date: 2018/6/27 12:00
 * @Description:
 */
public class Solution {
    static MidResult add(MidResult old, int x){
        return new MidResult(old.sum + x, old.count+1, old.average);
    }

    static class MidResult{
        int sum;
        int count;
        final Fraction average;

        public MidResult(int sum, int count, Fraction average) {
            this.sum = sum;
            this.count = count;
            this.average = average;
        }

        @Override
        public String toString() {
            return "" + sum + "," + count;
        }

        /**
         * 特征值
         * @return
         */
        public Fraction feature(){
            return new Fraction((long)sum, (long)1).minus(average.multiply(count));
        }

        @Override
        public int hashCode() {
            return ("" + feature()).hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            MidResult midResult = (MidResult) obj;
            return this.feature() == midResult.feature();
        }
    }

    //特征值集合
    Set<Fraction> midSet = new HashSet();
    //特征值映射数量
    Map<Fraction, Set<Integer>> featureToCount = new HashMap<>();

    int[] A;
    int leftEnd = 0;
    Fraction average;

    public boolean splitArraySameAverage(int[] A) {
        if (A == null || A.length <= 1) return false;

        this.A = A;
        leftEnd = (A.length-1)/2;
        int sum = Arrays.stream(A).sum();
        average = new Fraction((long)sum, (long)A.length).reduce();

        processLeftHalf();
        return processRightHalf();
    }

    /**
     * 处理数组左半部分的数据，将结果存到map
     */
    void processLeftHalf(){
        nextlevel(new MidResult(A[0], 1, average), 1);
        nextlevel(new MidResult(0, 0, average), 1);
    }

    /**
     * 处理右半部分数据，并查找，尝试匹配数据
     */
    boolean processRightHalf(){
        return nextlevelRight(new MidResult(A[leftEnd+1], 1, average), leftEnd+2);
    }

    /**
     *
     * @param parent
     * @param nextlevel 这里就是索引
     */
    private void nextlevel(MidResult parent, int nextlevel){
        if (nextlevel > leftEnd){
            midSet.add(parent.feature());
            Set<Integer> integers = featureToCount.get(parent.feature());
            if (integers == null){
                integers = new HashSet<>();
                featureToCount.put(parent.feature(), integers);
            }
            integers.add(parent.count);
            return;
        }
        nextlevel(add(parent, A[nextlevel]), nextlevel+1);
        nextlevel(parent, nextlevel+1);
    }

    private boolean nextlevelRight(MidResult parent, int nextlevel){
        if (nextlevel == A.length){
            //平均数是否相等？
            boolean featureFound = midSet.contains(parent.feature().negative());
            //数量是否满足,B集合不能把所有数选了
            if (featureFound){
                Set<Integer> integers = featureToCount.get(parent.feature().negative());
                //连个子集合的数量和为总数。
                if (integers.size() == 1 && integers.contains(A.length - parent.count)){
                    return false;
                }
                return true;
            }else {
                return false;
            }
        }
        return nextlevelRight(add(parent, A[nextlevel]), nextlevel+1)
                || nextlevelRight(parent, nextlevel+1);
    }

    static class Tuple<X, Y> {
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

    static class Fraction extends Tuple<Long, Long> {
        public Fraction() {
        }

        public Fraction(Long a, Long b) {
            super(a, b);
        }

        public Fraction multiply(int a){
            long x = this.x * a;
            return new Fraction(x, y).reduce();
        }

        public Fraction minus(Fraction subtrahend){
            long x = this.x * subtrahend.y - this.y * subtrahend.x;
            long y = this.y * subtrahend.y;
            return new Fraction(x,y).reduce();
        }

        public Fraction negative(){
            if (x == 0){
                return new Fraction(0L, 1L);
            }
            return new Fraction(this.x, -y);
        }

        public Fraction reduce(){
            if (x.equals(0)){
                //标准化无穷
                y = y > 0? 1L:-1L;
                return this;
            }
            //注意越界
            long gcd = gcd(Math.abs(x), Math.abs(y));
            x = x / gcd;
            y = y / gcd;
            normalizeSign();
            return this;
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
}
