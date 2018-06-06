package wang.tyrael.leetcode.math.divide29;

import java.util.BitSet;

/**
 * @author: wangchao
 * 2018/6/6 0006
 */
public class Solution {
    public int divide(int dividend, int divisor) {

        long lDividend = dividend,
                lDivisor = divisor;
        lDividend = dividend < 0 ? -lDividend : lDividend;
                lDivisor = divisor < 0 ? -lDivisor : lDivisor;
        boolean n1 = dividend < 0;
        boolean n2 = divisor < 0;
        long pResult = dividePositive(lDividend, lDivisor);
        if (n1 ^ n2) {
            return (int) -pResult;
        } else {
            return pResult > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) pResult;
        }
    }

    private long dividePositive(long dividend, long divisor) {
        long result = 0;
        //二进制长除，避免乘法。
        //对齐最高位
        //  3 2 1 0
        int mostSignificant = 0;
        //超出一位
        while (dividend >= divisor) {
            divisor <<= 1;
            mostSignificant++;
        }
        //对齐
        mostSignificant--;
        divisor >>= 1;
        for (int i = mostSignificant; i >= 0; i--) {
            if (dividend >= divisor) {
                //设置为1
                result |= (1L << i);
                dividend -= divisor;
            }
            divisor >>= 1;
        }
        return result;
    }
}
