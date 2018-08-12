package wang.tyrael.leetcode.array;

import org.junit.Test;
import wang.tyrael.ArrayUtil;
import wang.tyrael.leetcode.geometry.skyline218.Solution;

import java.util.List;

public class Skyline218 {
    //    [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
//            [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
    @Test
    public void test() {
        Solution solution = new Solution();
        List<int[]> result = solution.getSkyline(
                ArrayUtil.parse2D("[[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]"));
        System.out.println("[[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]:");
        ArrayUtil.printIntArray(result);
        System.out.println();
    }

    //
    @Test
    public void test1() {
        Solution solution = new Solution();
        List<int[]> result = solution.getSkyline(
                ArrayUtil.parse2D("[[0,1,3]]"));
        System.out.println(":");
        ArrayUtil.printIntArray(result);
        System.out.println();
    }

    //    [[1,5,3]
//            [1,5,3]
//            [1,5,3]]
    @Test
    public void test2() {
        Solution solution = new Solution();
        List<int[]> result = solution.getSkyline(
                ArrayUtil.parse2D("[[1,5,3]\n" +
                        "[1,5,3]\n" +
                        "[1,5,3]]"));
        System.out.println(":");
        ArrayUtil.printIntArray(result);
        System.out.println();
    }

    @Test
    public void test3() {
        Solution solution = new Solution();
        List<int[]> result = solution.getSkyline(
                ArrayUtil.parse2D("[[0,2,3],[2,5,3]]"));
        System.out.println("[[0,3],[5,0]]:");
        ArrayUtil.printIntArray(result);
        System.out.println();
    }
}
