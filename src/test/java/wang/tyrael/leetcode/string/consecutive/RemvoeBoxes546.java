package wang.tyrael.leetcode.string.consecutive;

import org.junit.Test;
import wang.tyrael.ArrayUtil;
import wang.tyrael.leetcode.TestStatic;
import wang.tyrael.leetcode.string.consective.removeboxes546.Solution;

public class RemvoeBoxes546 {
    @Test
    public void test(){
        Solution solution = new Solution();
        int result = solution.removeBoxes(ArrayUtil.parse("[1, 3, 2, 2, 2, 3, 4, 3, 1]"));
        TestStatic.printlnResult(result);
        assert result == 23;
    }

    @Test
    public void test0(){
        Solution solution = new Solution();
        int result = solution.removeBoxes(ArrayUtil.parse("[]"));
        TestStatic.printlnResult(result);
        assert result == 0;
    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        int result = solution.removeBoxes(ArrayUtil.parse("[1]"));
        TestStatic.printlnResult(result);
        assert result == 1;
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        int result = solution.removeBoxes(ArrayUtil.parse("[1,2]"));
        TestStatic.printlnResult(result);
        assert result == 2;
    }

    @Test
    public void test4(){
        Solution solution = new Solution();
        int result = solution.removeBoxes(ArrayUtil.parse("[1,1]"));
        TestStatic.printlnResult(result);
        assert result == 4;
    }

    @Test
    public void test5(){
        Solution solution = new Solution();
        int result = solution.removeBoxes(ArrayUtil.parse("" +
                "[3, 8, 8, 5, 5, 3, 9, 2, 4, 4, 6, 5, 8, 4, " +
                "8, 6, 9, 6, 2, 8, 6, 4, 1, 9, 5, 3, 10, " +
                "5, 3, 3, 9, 8, 8, 6, 5, 3, 7, 4, 9, 6, " +
                "3, 9, 4, 3, 5, 10, 7, 6, 10, 7]"));
        TestStatic.printlnResult(result);
        assert result == 136;
    }
}
