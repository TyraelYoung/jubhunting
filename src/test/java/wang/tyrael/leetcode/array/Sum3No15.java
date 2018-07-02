package wang.tyrael.leetcode.array;

import javafx.print.Collation;
import org.junit.Test;
import wang.tyrael.ArrayUtil;
import wang.tyrael.leetcode.TestStatic;
import wang.tyrael.leetcode.array.sum3No15.Solution;

import java.util.Collections;

/**
 * @Auther: wangchao
 * @Date: 2018/7/2 11:50
 * @Description:
 */
public class Sum3No15 {
    @Test
    public void test(){
        TestStatic.assertResult(ArrayUtil.parse2DInteger("[\n" +
                        "  [-1, 0, 1],\n" +
                        "  [-1, -1, 2]\n" +
                        "]"),
                new Solution().threeSum(ArrayUtil.parse("[-1, 0, 1, 2, -1, -4]")));
    }
}
