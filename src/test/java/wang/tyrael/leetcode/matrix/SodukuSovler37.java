package wang.tyrael.leetcode.matrix;

import org.junit.Test;
import wang.tyrael.leetcode.matrix.sudoku.sudokusolver37.Solution;
import wang.ArrayUtil;

/**
 * @author: wangchao
 * 2018/4/27 0027
 */
public class SodukuSovler37 {
    @Test
    public void test(){
        Solution solution = new Solution();
        char[][] board = ArrayUtil.parseChar2D("[" +
                "[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"]," +
                "[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"]," +
                "[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"]," +
                "[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"]," +
                "[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"]," +
                "[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"]," +
                "[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"]," +
                "[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"]," +
                "[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]");
        solution.solveSudoku(board);
        System.out.println("[[\"5\",\"3\",\"4\",\"6\",\"7\",\"8\",\"9\",\"1\",\"2\"],[\"6\",\"7\",\"2\",\"1\",\"9\",\"5\",\"3\",\"4\",\"8\"],[\"1\",\"9\",\"8\",\"3\",\"4\",\"2\",\"5\",\"6\",\"7\"],[\"8\",\"5\",\"9\",\"7\",\"6\",\"1\",\"4\",\"2\",\"3\"],[\"4\",\"2\",\"6\",\"8\",\"5\",\"3\",\"7\",\"9\",\"1\"],[\"7\",\"1\",\"3\",\"9\",\"2\",\"4\",\"8\",\"5\",\"6\"],[\"9\",\"6\",\"1\",\"5\",\"3\",\"7\",\"2\",\"8\",\"4\"],[\"2\",\"8\",\"7\",\"4\",\"1\",\"9\",\"6\",\"3\",\"5\"],[\"3\",\"4\",\"5\",\"2\",\"8\",\"6\",\"1\",\"7\",\"9\"]]");
        ArrayUtil.print(board);
    }
}