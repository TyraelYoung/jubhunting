package wang.tyrael.lintcode.string;

import org.junit.Test;
import wang.tyrael.leetcode.TestStatic;
import wang.tyrael.lintcode.string.decodeways512.Solution;

/**
 * @author: wangchao
 * 2018/7/28 0028
 */
public class DecodeWays512 {
    @Test
    public void test(){
        TestStatic.assertResult(1, new Solution().numDecodings("1"));
    }

    @Test
    public void test1(){
        TestStatic.assertResult(2, new Solution().numDecodings("12"));
    }

    @Test
    public void test2(){
        TestStatic.assertResult(8, new Solution().numDecodings("192611"));
    }
}
