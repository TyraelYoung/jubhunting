package wang.tyrael.leetcode;

import org.junit.Test;
import wang.tyrael.leetcode.verifypreorder.Solution;

/**
 * @author: wangchao
 * 2018/4/23 0023
 */
public class VerifyPreorder331 {
    @Test
    public void test(){
        Solution solution = new Solution();
        boolean result = solution.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
        assert result;
    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        boolean result = solution.isValidSerialization("1,#");
        assert !result;
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        boolean result = solution.isValidSerialization("9,#,#,1");
        assert !result;
    }

    @Test
    public void test3(){
        Solution solution = new Solution();
        boolean result = solution.isValidSerialization("");
        assert !result;
    }

    @Test
    public void test4(){
        Solution solution = new Solution();
        boolean result = solution.isValidSerialization("#");
        assert result;
    }

    @Test
    public void test5(){
        Solution solution = new Solution();
        boolean result = solution.isValidSerialization("##");
        assert !result;
    }
}
