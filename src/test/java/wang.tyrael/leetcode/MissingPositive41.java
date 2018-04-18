package wang.tyrael.leetcode;

import org.junit.Test;
import wang.tyrael.ArrayUtil;
import wang.tyrael.leetcode.missingpositive41.Solution;

public class MissingPositive41 {
    @Test
    public void test(){
        Solution solution = new Solution();
        int result;
        result = solution.firstMissingPositive(ArrayUtil.parse("[1,2,0]"));
        System.out.println("result:" + result);
        assert result == 3;

        result = solution.firstMissingPositive(ArrayUtil.parse("[3,4,-1,1]"));
        System.out.println("result:" + result);
        assert result == 2;

        result = solution.firstMissingPositive(ArrayUtil.parse("[7,8,9,11,12]"));
        System.out.println("result:" + result);
        assert result == 1;
    }
}
