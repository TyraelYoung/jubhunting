package wang.tyrael.leetcode;

import org.junit.Test;
import wang.tyrael.ArrayUtil;
import wang.tyrael.leetcode.BricksFalling803.Solution;

public class BricksFalling {
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


}
