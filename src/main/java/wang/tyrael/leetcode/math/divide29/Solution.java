package wang.tyrael.leetcode.math.divide29;

import java.util.BitSet;

/**
 * @author: wangchao
 * 2018/6/6 0006
 */
public class Solution {
    public int divide(int dividend, int divisor){
        return 0;
    }

    public int dividePositive(int dividend, int divisor){
        int result = 0;
        //二进制长除，避免乘法。
        //对齐最高位
        //  3 2 1 0
        int mostSignificant = 0;
        //超出一位
        while (dividend >= divisor){
            divisor <<= 1;
            mostSignificant ++;
        }
        //对齐
        mostSignificant--;
        divisor >>=1;
        for (int i = mostSignificant; i >= 0 ; i++) {
            if (dividend >= divisor){
                //设置为1
                result |= 1 << i;
                dividend -= divisor;
            }
            divisor >>=1;
        }
        return result;
    }
}
