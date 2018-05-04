package wang.tyrael.leetcode;

import org.junit.Test;
import wang.ArrayUtil;
import wang.tyrael.leetcode.gasstation134.Solution;

public class GasStation134 {
    @Test
    public void test1(){
        Solution solution = new Solution();
        int result;
        result = solution.canCompleteCircuit(
                ArrayUtil.parse("[2,3,4]"),
                ArrayUtil.parse("[3,4,3]"));
        System.out.println("result:" + result);
        assert result == -1;
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        int result;
        result = solution.canCompleteCircuit(
                ArrayUtil.parse("[1,2,3,4,5]"),
                ArrayUtil.parse("[3,4,5,1,2]"));
        System.out.println("result:" + result);
        assert result == 3;
    }


}
