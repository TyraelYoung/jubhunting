package wang.tyrael.leetcode.array;

import org.junit.Test;
import wang.tyrael.ArrayUtil;
import wang.tyrael.leetcode.TestStatic;
import wang.tyrael.leetcode.array.sum3No15.Solution;

/**
 * @Auther: wangchao
 * @Date: 2018/7/2 11:50
 * @Description:
 */
public class Sum3No15 {
    @Test
    public void test(){
        TestStatic.assertAndPrint(ArrayUtil.parse2DInteger("[\n" +
                        "  [-1, 0, 1],\n" +
                        "  [-1, -1, 2]\n" +
                        "]"),
                new Solution().threeSum(ArrayUtil.parse("[-1, 0, 1, 2, -1, -4]")));
    }

//    Input:
//            [-2,0,1,1,2]
//    Output:
//            [[-2,0,2]]
//    Expected:
//            [[-2,0,2],[-2,1,1]]
    @Test
    public void test1(){
        TestStatic.assertAndPrint(ArrayUtil.parse2DInteger("[[-2,0,2],[-2,1,1]]"),
                new Solution().threeSum(ArrayUtil.parse("[-2,0,1,1,2]")));
    }
}
