package wang.tyrael.leetcode;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import wang.tyrael.ArrayUtil;
import wang.tyrael.leetcode.twentyfour679.Solution;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

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
