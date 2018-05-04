package wang.tyrael.leetcode;

import org.junit.Test;
import wang.tyrael.leetcode.removeduplicate316.Solution;

/**
 * @author: wangchao
 * 2018/4/26 0026
 */
public class RemoveDuplicate316 {
    @Test
    public void test(){
        Solution solution = new Solution();
        String result = solution.removeDuplicateLetters("bcabc");
        System.out.println("result:" + result);
        assert "abc".equals(result);
    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        String result = solution.removeDuplicateLetters("cbacdcbc");
        System.out.println("result:" + result);
        assert "acdb".equals(result);
    }
}
