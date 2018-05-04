package wang.tyrael.leetcode;

import org.junit.Test;
import wang.ArrayUtil;
import wang.tyrael.leetcode.trappingRain42.Solution;


public class TrappingRain42 {
    @Test
    public void test(){
        int[] input;
        int result;
        Solution solution = new Solution();
        input = ArrayUtil.parse("[0,1,0,2,1,0,1,3,2,1,2,1]");
        result = solution.trap(input);
        System.out.println("6:" + result);
        assert result == 6;

//        [5,2,1,2,1,5]
        input = ArrayUtil.parse("[5,2,1,2,1,5]");
        result = solution.trap(input);
        System.out.println("14:" + result);
        assert result == 14;

    }
}
