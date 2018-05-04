package wang.tyrael.leetcode.math;

import org.junit.Test;
import wang.ArrayUtil;
import wang.tyrael.leetcode.TestStatic;
import wang.tyrael.leetcode.math.productsubarray152.Solution;

/**
 * @author: wangchao
 * 2018/5/3 0003
 */
public class ProductSubarray152 {
    @Test
    public void test(){
        Solution solution = new Solution();
        int result = solution.maxProduct(ArrayUtil.parse("[2,3,-2,4]"));
        TestStatic.printlnResult(result);
        assert result == 6;
    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        int result = solution.maxProduct(ArrayUtil.parse("[-2,0,-1]"));
        TestStatic.printlnResult(result);
        assert result == 0;
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        int result = solution.maxProduct(ArrayUtil.parse("[]"));
        TestStatic.printlnResult(result);
        assert result == 0;
    }

    @Test
    public void test3(){
        Solution solution = new Solution();
        int result = solution.maxProduct(ArrayUtil.parse("[-1]"));
        TestStatic.printlnResult(result);
        assert result == -1;
    }

    @Test
    public void test4(){
        Solution solution = new Solution();
        int result = solution.maxProduct(ArrayUtil.parse("[0]"));
        TestStatic.printlnResult(result);
        assert result == 0;
    }

    @Test
    public void test5(){
        Solution solution = new Solution();
        int result = solution.maxProduct(ArrayUtil.parse("[0, 0]"));
        TestStatic.printlnResult(result);
        assert result == 0;
    }

    @Test
    public void test6(){
        Solution solution = new Solution();
        int result = solution.maxProduct(ArrayUtil.parse("[-1, -1]"));
        TestStatic.printlnResult(result);
        assert result == 1;
    }

    @Test
    public void test7(){
        Solution solution = new Solution();
        int result = solution.maxProduct(ArrayUtil.parse("[0, 2]"));
        TestStatic.printlnResult(result);
        assert result == 2;
    }

    @Test
    public void test8(){
        Solution solution = new Solution();
        int result = solution.maxProduct(ArrayUtil.parse("[-4,-3,-2]"));
        TestStatic.printlnResult(result);
        assert result == 12;
    }
}
