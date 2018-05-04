package wang.tyrael.leetcode;

import org.junit.Test;
import wang.tyrael.leetcode.divide29.Solution;

/**
 * @author: wangchao
 * 2018/4/20 0020
 */
public class Divide29 {
//    -2147483648
//            -1

    @Test
    public void test(){
        Solution solution = new Solution();
        int result = solution.divide(-2147483648, -1);
        System.out.println("result:" + result);
        assert result == Integer.MAX_VALUE;
    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        int result = solution.divide(1, 1);
        System.out.println("result:" + result);
        assert result == 1;
    }
}
