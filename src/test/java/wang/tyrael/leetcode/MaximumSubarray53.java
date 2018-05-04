package wang.tyrael.leetcode;

import org.junit.Test;
import wang.tyrael.leetcode.maximumsubarray.Solution;
import wang.ArrayUtil;

public class MaximumSubarray53 {
    @Test
    public void test1(){
        Solution solution = new Solution();
        int result = solution.maxSubArray(ArrayUtil.parse("[-1]"));
        System.out.println("result:" + result);
        assert result == -1;
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        int result = solution.maxSubArray(ArrayUtil.parse("[-2,1,-3,4,-1,2,1,-5,4]"));
        System.out.println("result:" + result);
        assert result == 6;
    }
}
