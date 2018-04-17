package wang.tyrael.leetcode;

import org.junit.Test;
import wang.tyrael.ArrayUtil;
import wang.tyrael.leetcode.countsmaller315.Solution;

import java.util.List;

public class CountSmaller315 {
    //[2, 1, 1, 0]
    @Test
    public void test(){
        Solution solution = new Solution();
        List<Integer> result = solution.countSmaller(ArrayUtil.parse("[5, 2, 6, 1]"));
        ArrayUtil.printInt(result);
    }
}
