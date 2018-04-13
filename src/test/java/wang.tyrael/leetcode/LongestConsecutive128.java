package wang.tyrael.leetcode;

import org.junit.Test;
import wang.tyrael.ArrayUtil;
import wang.tyrael.leetcode.longestconsecutive128.Solution;

/**
 * @author: wangchao
 */
public class LongestConsecutive128 {
    //[0,3,7,2,5,8,4,6,0,1]
    @Test
    public void test2(){
        Solution solution = new Solution();
        int result = solution.longestConsecutive(ArrayUtil.parse("[0,3,7,2,5,8,4,6,0,1]"));
        System.out.println(result);
        assert result == 9;
    }

    //[0,0,-1]
    @Test
    public void test1(){
        Solution solution = new Solution();
        int result = solution.longestConsecutive(ArrayUtil.parse("[0,0,-1]"));
        System.out.println(result);
        assert result == 2;
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        int result = solution.longestConsecutive(ArrayUtil.parse("[100, 4, 200, 1, 3, 2]"));
        System.out.println(result);
        assert result == 4;
    }
}
