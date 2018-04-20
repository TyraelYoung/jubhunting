package wang.tyrael.leetcode.divide29;

/**
 * @author: wangchao
 * 2018/4/20 0020
 */
public class SolutionTLE {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }
        long count = 0;
        long dividend1 = Math.abs((long)dividend);
        long divisor1 = Math.abs((long)divisor);
        while (dividend1 >= divisor1) {
            dividend1 -= divisor1;
            count++;
        }
        if(count > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }

        if (sign > 0){
            return (int) count;
        }else{
            return (int) -count;
        }
    }
}
