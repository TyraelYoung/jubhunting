package wang.tyrael.leetcode;

import org.junit.Test;
import wang.tyrael.leetcode.erectfence587.Solution;
import wang.ArrayUtil;
import wang.tyrael.basic.Point;

import java.util.List;

/**
 * @author: wangchao
 * 2018/4/17 0017
 */
public class ErectFence {
//    Input:
//            [[3,0],[4,0],[5,0],[6,1],[7,2],[7,3],[7,4],[6,5],[5,5],[4,5],[3,5],[2,5],[1,4],[1,3],[1,2],[2,1],[4,2],[0,3]]
//    Output:
//            [[3,0],[5,0],[6,1],[7,2],[7,3],[7,4],[6,5],[5,5],[4,5],[3,5],[2,5],[1,4],[0,3]]
//    Expected:
//            [[0,3],[1,2],[2,1],[3,0],[4,0],[5,0],[6,1],[7,2],[7,3],[7,4],[6,5],[5,5],[4,5],[3,5],[2,5],[1,4]]
    @Test
    public void test4(){
        Solution solution = new Solution();
        List<Point> result;
        result = solution.outerTrees(ArrayUtil.parsePoint("[[3,0],[4,0],[5,0]," +
                "[6,1],[7,2],[7,3],[7,4],[6,5],[5,5],[4,5],[3,5],[2,5],[1,4]," +
                "[1,3],[1,2],[2,1],[4,2],[0,3]]"));
        System.out.println();
        System.out.println("[[0,3],[1,2],[2,1],[3,0],[4,0],[5,0],[6,1],[7,2],[7,3],[7,4],[6,5],[5,5],[4,5],[3,5],[2,5],[1,4]]:");
        ArrayUtil.printPoint(result);
        System.out.println();

    }

    //[[0,0],[1,1],[100,100]]
    @Test
    public void test3(){
        Solution solution = new Solution();
        List<Point> result;
        result = solution.outerTrees(ArrayUtil.parsePoint("[[0,0],[1,1],[100,100]]"));
        System.out.println(":");
        ArrayUtil.printPoint(result);
        System.out.println();

    }

    //[[5,3],[7,5]]
    @Test
    public void test2(){
        Solution solution = new Solution();
        List<Point> result;
        result = solution.outerTrees(ArrayUtil.parsePoint("[[5,3],[7,5]]"));
        System.out.println(":");
        ArrayUtil.printPoint(result);
        System.out.println();

    }

    @Test
    public void test1(){
//        Input: [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
//        Output: [[1,1],[2,0],[4,2],[3,3],[2,4]]
        Solution solution = new Solution();
        List<Point> result;
        result = solution.outerTrees(ArrayUtil.parsePoint("[[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]"));
        System.out.println("[[1,1],[2,0],[4,2],[3,3],[2,4]]:");
        ArrayUtil.printPoint(result);
        System.out.println();

    }

    @Test
    public void test(){
        Solution solution = new Solution();
        List<Point> result;
//        Input: [[1,2],[2,2],[4,2]]
//        Output: [[1,2],[2,2],[4,2]]
        result = solution.outerTrees(ArrayUtil.parsePoint("[[1,2],[2,2],[4,2]]"));
        System.out.println("[[1,2],[2,2],[4,2]]:");
        ArrayUtil.printPoint(result);
        System.out.println();

    }
}
