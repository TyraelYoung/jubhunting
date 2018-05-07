package wang.tyrael.leetcode.array;

import org.junit.Test;
import wang.ArrayUtil;
import wang.tyrael.leetcode.TestStatic;
import wang.tyrael.leetcode.array.ChunksSort769.Solution;

public class ChunksSort {
    @Test
    public void test(){
        Solution solution = new Solution();
        int result = solution.maxChunksToSorted(ArrayUtil.parse("[4,3,2,1,0]"));
        TestStatic.printlnResult(result);
        assert result == 1;
    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        int result = solution.maxChunksToSorted(ArrayUtil.parse("[1,0,2,3,4]"));
        TestStatic.printlnResult(result);
        assert result == 4;
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        int result = solution.maxChunksToSorted(ArrayUtil.parse("[]"));
        TestStatic.printlnResult(result);
        assert result == 0;
    }
}
