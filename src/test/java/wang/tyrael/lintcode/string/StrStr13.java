package wang.tyrael.lintcode.string;

import org.junit.Test;
import wang.tyrael.leetcode.TestStatic;
import wang.tyrael.lintcode.string.strstr13.Solution;

/**
 * @author: wangchao
 * 2018/7/28 0028
 */
public class StrStr13 {
    @Test
    public void test(){
        TestStatic.assertResult(1, new Solution().strStr("abcdabcdefg", "bcd"));
    }

    @Test
    public void test1(){
        TestStatic.assertResult(0, new Solution().strStr("a", ""));
    }

    @Test
    public void test2(){
        TestStatic.assertResult(-1, new Solution().strStr(null, "a"));
    }
}
