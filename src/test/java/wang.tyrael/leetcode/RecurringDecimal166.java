package wang.tyrael.leetcode;

import org.junit.Test;
import wang.tyrael.leetcode.recurringdecimal166.Solution;

public class RecurringDecimal166 {
    @Test
    public void test(){
        Solution solution = new Solution();
        String result = solution.fractionToDecimal(0, -1);
        System.out.println("result:" + result);
        assert "0".equals(result);
    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        String result = solution.fractionToDecimal(Integer.MAX_VALUE, -1);
        System.out.println("result:" + result);
//        assert "0".equals(result);
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        String result = solution.fractionToDecimal(Integer.MIN_VALUE, -1);
        System.out.println("result:" + result);
        assert "2147483648".equals(result);
    }

    @Test
    public void test3(){
        Solution solution = new Solution();
        String result = solution.fractionToDecimal(1, 2);
        System.out.println("result:" + result);
        assert "0.5".equals(result);
    }

    @Test
    public void test4(){
        Solution solution = new Solution();
        String result = solution.fractionToDecimal(2, 1);
        System.out.println("result:" + result);
        assert "2".equals(result);
    }

    @Test
    public void test5(){
        Solution solution = new Solution();
        String result = solution.fractionToDecimal(2, 3);
        System.out.println("result:" + result);
        assert "0.(6)".equals(result);
    }

//    @Test
//    public void test6(){
//        Solution solution = new Solution();
//        String result = solution.fractionToDecimal(Integer.MAX_VALUE-1, Integer.MAX_VALUE);
//        System.out.println("result:" + result);
////        assert "0.(6)".equals(result);
//    }

    @Test
    public void test7(){
        Solution solution = new Solution();
        String result = solution.fractionToDecimal(1, 6);
        System.out.println("result:" + result);
        assert "0.1(6)".equals(result);
    }

    @Test
    public void test8(){
        Solution solution = new Solution();
        String result = solution.fractionToDecimal(-50, 8);
        System.out.println("result:" + result);
        assert "-6.25".equals(result);
    }

    @Test
    public void test9(){
        Solution solution = new Solution();
        String result = solution.fractionToDecimal(7, -12);
        System.out.println("result:" + result);
        assert "-0.58(3)".equals(result);
    }

}
