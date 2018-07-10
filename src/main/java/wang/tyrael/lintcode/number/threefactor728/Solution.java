package wang.tyrael.lintcode.number.threefactor728;

/**
 * 必然是素数的平方
 * @Auther: wangchao
 * @Date: 2018/7/10 20:09
 * @Description:
 */
public class Solution {
    /**
     * @param n: the given number
     * @return:  return true if it has exactly three distinct factors, otherwise false
     */
    public boolean isThreeDisctFactors(long n) {
        // write your code here
        long sq = (long) Math.sqrt(n);
        if (sq * sq != n) return false;
        return isPrime(sq);

    }

    private boolean isPrime(long a){
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) return false;
        }
        return true;
    }
}
