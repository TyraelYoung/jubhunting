package wang.tyrael.leetcode;

import org.junit.Test;
import wang.tyrael.leetcode.atoi8.Solution;

public class Atoi {
    @Test
    public void test(){
        Solution solution = new Solution();
        int result;
        result = solution.myAtoi("111");
        System.out.println("111:" + result);

        result = solution.myAtoi("  111");
        System.out.println("111:" + result);

        result = solution.myAtoi("  000");
        System.out.println("000:" + result);

        result = solution.myAtoi("  -1sdfs");
        System.out.println("-1:" + result);

        result = solution.myAtoi("1");
        System.out.println("1:" + result);
    }
}
