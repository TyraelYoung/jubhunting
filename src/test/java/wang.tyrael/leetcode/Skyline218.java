package wang.tyrael.leetcode;

import org.junit.Test;
import wang.tyrael.ArrayUtil;
import wang.tyrael.leetcode.skyline218.Solution;

import java.util.List;

public class Skyline218 {
//    [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
//            [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
    @Test
    public void test(){
        Solution solution = new Solution();
        List<int[]> result = solution.getSkyline(
                ArrayUtil.parse2D("[[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]"));
        System.out.println("[[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]:");
        ArrayUtil.printIntArray(result);
    }
}
