package wang.tyrael.leetcode;

import org.junit.Test;
import wang.tyrael.leetcode.longestincreasing.Solution;
import wang.ArrayUtil;

public class LongestIncreasing329 {
    @Test
    public void test(){
        Solution solution = new Solution();
        int result = solution.longestIncreasingPath(ArrayUtil.parse2D("[\n" +
                "  [9,9,4],\n" +
                "  [6,6,8],\n" +
                "  [2,1,1]\n" +
                "]"));
        ArrayUtil.print(solution.cache);
        assert result == 4;

    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        int result = solution.longestIncreasingPath(ArrayUtil.parse2D(" [\n" +
                "  [3,4,5],\n" +
                "  [3,2,6],\n" +
                "  [2,2,1]\n" +
                "]"));
        assert result == 4;
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        int result = solution.longestIncreasingPath(ArrayUtil.parse2D(" []"));
        assert result == 0;
    }
}
