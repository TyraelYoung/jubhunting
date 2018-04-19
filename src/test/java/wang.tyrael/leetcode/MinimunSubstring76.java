package wang.tyrael.leetcode;

import org.junit.Test;
import wang.tyrael.leetcode.minimumsubstring.Solution;

/**
 * @author: wangchao
 * 2018/4/19 0019
 */
public class MinimunSubstring76 {
    @Test
    public void test(){
        Solution solution = new Solution();
        String result = solution.minWindow("ADOBECODEBANC", "ABC");
        System.out.println("result:" + result);
        assert "BANC".equals(result);
    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        String result = solution.minWindow("a", "aa");
        System.out.println("result:" + result);
        assert "".equals(result);
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        String result = solution.minWindow("aa", "aa");
        System.out.println("result:" + result);
        assert "aa".equals(result);
    }

    @Test
    public void test3(){
        Solution solution = new Solution();
        String result = solution.minWindow("bba", "ab");
        System.out.println("result:" + result);
        assert "ba".equals(result);
    }
}
