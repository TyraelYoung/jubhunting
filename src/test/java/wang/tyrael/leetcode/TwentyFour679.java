package wang.tyrael.leetcode;

import org.junit.Test;
import wang.tyrael.leetcode.twentyfour679.Solution;
import wang.tyrael.ArrayUtil;

public class TwentyFour679 {
    @Test
    public void test(){
        Solution solution = new Solution();
        int[] input;
        boolean result;

//        input = ArrayUtil.parse("[1, 2, 1, 2]");
//        result = solution.judgePoint24(input);
//        assert !result;
//
//        input = ArrayUtil.parse("[4, 1, 8, 7]");
//        result = solution.judgePoint24(input);
//        assert result;
        input = ArrayUtil.parse("[3, 9, 7, 7]");
        result = solution.judgePoint24(input);
        assert result;
    }

}
