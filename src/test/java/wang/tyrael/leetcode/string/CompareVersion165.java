package wang.tyrael.leetcode.string;

import org.junit.Test;
import wang.tyrael.leetcode.TestStatic;
import wang.tyrael.leetcode.string.compareversion165.Solution;

/**
 * @Auther: wangchao
 * @Date: 2018/6/29 17:31
 * @Description:
 */
public class CompareVersion165 {
    @Test
    public void test(){
        TestStatic.assertResult(-1, new Solution().compareVersion("0.1", "1.1"));
    }

    @Test
    public void test1(){
        TestStatic.assertResult(1, new Solution().compareVersion("1.0.1", "1"));
    }

    @Test
    public void test2(){
        TestStatic.assertResult(-1, new Solution().compareVersion("7.5.2.4", "7.5.3"));
    }

    @Test
    public void test3(){
        TestStatic.assertResult(0, new Solution().compareVersion("", ""));
    }

    @Test
    public void test4(){
        TestStatic.assertResult(0, new Solution().compareVersion("1.0", "1"));
    }
}
