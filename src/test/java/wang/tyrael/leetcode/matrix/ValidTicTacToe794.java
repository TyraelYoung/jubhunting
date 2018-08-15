package wang.tyrael.leetcode.matrix;

import org.junit.Test;
import wang.tyrael.ArrayUtil;
import wang.tyrael.leetcode.TestStatic;
import wang.tyrael.leetcode.matrix.tictactoe.validtictactoe794.Solution;

/**
 * @Auther: wangchao
 * @Date: 2018/7/11 17:46
 * @Description:
 */
public class ValidTicTacToe794 {
    @Test
    public void test(){
        TestStatic.assertAndPrint(true,
                new Solution().validTicTacToe(ArrayUtil.parseString("[\"XXX\",\"OOX\",\"OOX\"]")));
    }

    @Test
    public void test1(){
        TestStatic.assertAndPrint(false,
                new Solution().validTicTacToe(ArrayUtil.parseString("[\"XXX\",\"XOO\",\"OO \"]")));

    }

    @Test
    public void test2(){
        TestStatic.assertAndPrint(false,
                new Solution().validTicTacToe(ArrayUtil.parseString("[\"OXX\",\"XOX\",\"OXO\"]")));

    }
}
