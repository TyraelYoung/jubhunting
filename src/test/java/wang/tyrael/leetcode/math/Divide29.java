package wang.tyrael.leetcode.math;

import org.junit.Test;
import wang.tyrael.leetcode.TestStatic;
import wang.tyrael.leetcode.math.divide29.Solution;

public class Divide29 {
    @Test
    public void test(){
        Solution solution = new Solution();
        int result = solution.divide(Integer.MIN_VALUE, -1);
        TestStatic.assertResult(Integer.MAX_VALUE, result);
    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        int result = solution.divide(1, -1);
        TestStatic.assertResult(-1, result);
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        int result = solution.divide(Integer.MAX_VALUE, Integer.MIN_VALUE);
        TestStatic.assertResult(0, result);
    }

    @Test
    public void test3(){
        Solution solution = new Solution();
        int result = solution.divide(Integer.MIN_VALUE, Integer.MAX_VALUE);
        TestStatic.assertResult(-1, result);
    }
}
