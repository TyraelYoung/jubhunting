package wang.tyrael.leetcode.jump;

import org.junit.Test;
import wang.tyrael.ArrayUtil;
import wang.tyrael.leetcode.TestStatic;
import wang.tyrael.leetcode.jump.frog403.Solution;

public class Forg403 {
    @Test
    public void test(){
        Solution solution = new Solution();
        boolean result = solution.canCross(ArrayUtil.parse("[0,1,3,5,6,8,12,17]"));
        TestStatic.printlnResult(result);
        assert result;
    }
    @Test
    public void test1(){
        Solution solution = new Solution();
        boolean result = solution.canCross(ArrayUtil.parse("[0,1,2,3,4,8,9,11]"));
        TestStatic.printlnResult(result);
        assert !result;
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        boolean result = solution.canCross(ArrayUtil.parse("[]"));
        TestStatic.printlnResult(result);
        assert !result;
    }

    @Test
    public void test3(){
        Solution solution = new Solution();
        boolean result = solution.canCross(ArrayUtil.parse("[0, 1]"));
        TestStatic.printlnResult(result);
        assert result;
    }

    @Test
    public void test4(){
        Solution solution = new Solution();
        boolean result = solution.canCross(ArrayUtil.parse("[0, 3]"));
        TestStatic.printlnResult(result);
        assert !result;
    }
}
