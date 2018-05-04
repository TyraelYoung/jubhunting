package wang.tyrael.leetcode.array.inversion;

import org.junit.Test;
import wang.ArrayUtil;
import wang.tyrael.leetcode.array.inversion.globallocal.Solution;

/**
 * @author: wangchao
 * 2018/5/4 0004
 */
public class GlobalLocal775 {
    @Test
    public void test(){
        Solution solution = new Solution();
        boolean result = solution.isIdealPermutation(ArrayUtil.parse("[1,0,2]"));
        assert result;
    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        boolean result = solution.isIdealPermutation(ArrayUtil.parse("[1,2,0]"));
        assert !result;
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        boolean result = solution.isIdealPermutation(ArrayUtil.parse("[]"));
        assert result;
    }

    @Test
    public void test3(){
        Solution solution = new Solution();
        boolean result = solution.isIdealPermutation(ArrayUtil.parse("[1]"));
        assert result;
    }
}
