package wang.tyrael.leetcode.digit;

import org.junit.Test;
import wang.tyrael.leetcode.TestStatic;
import wang.tyrael.leetcode.digit.removek.Solution;

/**
 * @author: wangchao
 * 2018/5/8 0008
 */
public class RemoveKDigits {
    @Test
    public void test0(){
        Solution solution = new Solution();
        String result = solution.removeKdigits("", 0);
        TestStatic.printlnResult(result);
        assert "0".equals(result);
    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        String result = solution.removeKdigits("", 1);
        TestStatic.printlnResult(result);
        assert "0".equals(result);
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        String result = solution.removeKdigits("0", 1);
        TestStatic.printlnResult(result);
        assert "0".equals(result);
    }

    @Test
    public void test3(){
        Solution solution = new Solution();
        String result = solution.removeKdigits("10", 2);
        TestStatic.printlnResult(result);
        assert "0".equals(result);
    }

    @Test
    public void test4(){
        Solution solution = new Solution();
        String result = solution.removeKdigits("1432219", 3);
        TestStatic.printlnResult(result);
        assert "1219".equals(result);
    }

    @Test
    public void test5(){
        Solution solution = new Solution();
        String result = solution.removeKdigits("10200", 2);
        TestStatic.printlnResult(result);
        assert "0".equals(result);
    }

    @Test
    public void test6(){
        Solution solution = new Solution();
        String result = solution.removeKdigits("10200", 1);
        TestStatic.printlnResult(result);
        assert "200".equals(result);
    }

//    "43214321"
//            4
    @Test
    public void test7(){
        Solution solution = new Solution();
        String result = solution.removeKdigits("43214321", 4);
        TestStatic.printlnResult(result);
        assert "1321".equals(result);
    }
}
