package wang.tyrael.leetcode.string;

import org.junit.Test;
import wang.tyrael.leetcode.string.reversewords151.Solution;

/**
 * @author: wangchao
 * 2018/5/31 0031
 */
public class ReverseWords151 {
    @Test
    public void test(){
        Solution solution = new Solution();
        String result = solution.reverseWords("");
        System.out.println("result:" + result);
        assert "".equals(result);
    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        String result = solution.reverseWords(" ");
        System.out.println("result:" + result);
        assert "".equals(result);
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        String result = solution.reverseWords("  123  456  ");
        System.out.println("result:" + result);
        assert "456 123".equals(result);
    }

    @Test
    public void test3(){
        Solution solution = new Solution();
        String result = solution.reverseWords("the sky is blue");
        System.out.println("result:" + result);
        assert "blue is sky the".equals(result);
    }
}
