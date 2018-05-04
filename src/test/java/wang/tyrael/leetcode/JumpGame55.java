package wang.tyrael.leetcode;

import org.junit.Test;
import wang.ArrayUtil;
import wang.tyrael.leetcode.jumpgame55.Solution;

/**
 * @author: wangchao
 */
public class JumpGame55 {
    @Test
    public void test(){
        Solution solution = new Solution();
        boolean result;
        result = solution.canJump(ArrayUtil.parse("[2,3,1,1,4]"));
        assert result;
    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        boolean result;
        result = solution.canJump(ArrayUtil.parse("[3,2,1,0,4]"));
        assert !result;
    }
}
