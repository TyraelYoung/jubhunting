package wang.tyrael.leetcode.array;

import org.junit.Test;
import wang.ArrayUtil;
import wang.tyrael.leetcode.TestStatic;
import wang.tyrael.leetcode.array.sum3closet16.Solution;

/**
 * @author: wangchao
 * 2018/5/4 0004
 */
public class Sum3Cloest16 {
    @Test
    public void test(){
        Solution solution = new Solution();
        int result = solution.threeSumClosest(ArrayUtil.parse("[-1, 2, 1, -4]"), 1);
        TestStatic.printlnResult(result);
        assert result == 2;
    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        int result = solution.threeSumClosest(ArrayUtil.parse("[]"), 1);
        TestStatic.printlnResult(result);
        assert result == 0;
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        int result = solution.threeSumClosest(ArrayUtil.parse("[-1, 2, 1]"), 2);
        TestStatic.printlnResult(result);
        assert result == 2;
    }
}
