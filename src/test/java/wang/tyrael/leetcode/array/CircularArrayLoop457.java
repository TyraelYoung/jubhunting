package wang.tyrael.leetcode.array;

import org.junit.Test;
import wang.tyrael.ArrayUtil;
import wang.tyrael.leetcode.TestStatic;
import wang.tyrael.leetcode.array.circulararrayloop457.Solution;


/**
 * @Auther: wangchao
 * @Date: 2018/7/9 11:15
 * @Description:
 */
public class CircularArrayLoop457 {
    @Test
    public void test(){
        TestStatic.assertResult(true, new Solution().circularArrayLoop(ArrayUtil.parse("[2, -1, 1, 2, 2]")));
    }

    @Test
    public void test1(){
        TestStatic.assertResult(false, new Solution().circularArrayLoop(ArrayUtil.parse(" [-1, 2]")));
    }

    @Test
    public void test2(){
        TestStatic.assertResult(false, new Solution().circularArrayLoop(ArrayUtil.parse(" [-2, 1, -1, -2, -2]")));
    }
}
