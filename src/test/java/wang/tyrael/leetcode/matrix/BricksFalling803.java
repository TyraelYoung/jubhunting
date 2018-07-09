package wang.tyrael.leetcode.matrix;

import org.junit.Test;
import wang.tyrael.ArrayUtil;
import wang.tyrael.leetcode.TestStatic;
import wang.tyrael.leetcode.matrix.bricksfalling803.Solution;

public class BricksFalling803 {
    @Test
    public void test(){
        Solution solution = new Solution();
        int[][] bricks = (int[][]) ArrayUtil.parse2D("[[1,0,0,0],[1,1,1,0]]");
        int[][] hits = (int[][]) ArrayUtil.parse2D("[[1,0]]");
        int[] result = solution.hitBricks(bricks, hits);
        System.out.println("[2]:");
        ArrayUtil.printArray(result);
        System.out.println();

        bricks = (int[][]) ArrayUtil.parse2D("[[1,0,0,0],[1,1,0,0]]");
        hits = (int[][]) ArrayUtil.parse2D("[[1,1],[1,0]]");
        result = solution.hitBricks(bricks, hits);
        System.out.println("[0,0]:");
        ArrayUtil.printArray(result);
        System.out.println();
    }

//    Input:
//            [[1],[1],[1],[1],[1]]
//            [[3,0],[4,0],[1,0],[2,0],[0,0]]
//    Output:
//            [-1,-1,-1,-1,-1]
//    Expected:
//            [1,0,1,0,0]
    @Test
    public void test1(){
        TestStatic.assertResult(ArrayUtil.parse("[1,0,1,0,0]"),
                new Solution().hitBricks(ArrayUtil.parse2D("[[1],[1],[1],[1],[1]]"),
                        ArrayUtil.parse2D("[[3,0],[4,0],[1,0],[2,0],[0,0]]")));
    }

//    Input:
//            [[1,1,1],[0,1,0],[0,0,0]]
//            [[0,2],[2,0],[0,1],[1,2]]
//    Output:
//            [0,0,2,0]
//    Expected:
//            [0,0,1,0]

    @Test
    public void test2(){
        TestStatic.assertResult(ArrayUtil.parse("[0,0,1,0]"),
                new Solution().hitBricks(ArrayUtil.parse2D("[[1,1,1],[0,1,0],[0,0,0]]"),
                        ArrayUtil.parse2D("[[0,2],[2,0],[0,1],[1,2]]")));
    }

//    Input:
//            [[0,1,1,1,1],[1,1,1,1,0],[1,1,1,1,0],[0,0,1,1,0],[0,0,1,0,0],[0,0,1,0,0],[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0]]
//            [[6,0],[1,0],[4,3],[1,2],[7,1],[6,3],[5,2],[5,1],[2,4],[4,4],[7,3]]
//    Output:
//            [0,1,0,0,0,0,0,0,0,0,0]
//    Expected:
//            [0,0,0,0,0,0,0,0,0,0,0]
    @Test
    public void test3(){
        TestStatic.assertResult(ArrayUtil.parse("[0,0,0,0,0,0,0,0,0,0,0]"),
                new Solution().hitBricks(
                        ArrayUtil.parse2D("[[0,1,1,1,1]," +
                                "[1,1,1,1,0],[1,1,1,1,0],[0,0,1,1,0]," +
                                "[0,0,1,0,0],[0,0,1,0,0],[0,0,0,0,0]," +
                                "[0,0,0,0,0],[0,0,0,0,0]]"),
                        ArrayUtil.parse2D("[[6,0],[1,0],[4,3],[1,2],[7,1],[6,3],[5,2],[5,1],[2,4],[4,4],[7,3]]")));
    }

}
