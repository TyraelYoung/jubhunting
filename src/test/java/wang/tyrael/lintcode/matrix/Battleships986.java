package wang.tyrael.lintcode.matrix;

import org.junit.Test;
import wang.tyrael.ArrayUtil;
import wang.tyrael.leetcode.TestStatic;
import wang.tyrael.lintcode.matrix.battleships986.Solution;

/**
 * @Auther: wangchao
 * @Date: 2018/7/11 15:34
 * @Description:
 */
public class Battleships986 {
    @Test
    public void test(){
        TestStatic.assertResult(0, new Solution().countBattleships(new char[0][0]));
    }

    @Test
    public void test1(){
        TestStatic.assertResult(0, new Solution().countBattleships(new char[][]{{'.'}}));
    }

    @Test
    public void test2(){
        TestStatic.assertResult(1, new Solution().countBattleships(new char[][]{{'X'}}));
    }

    @Test
    public void test3(){
        TestStatic.assertResult(2,
                new Solution().countBattleships(ArrayUtil.parseChar2D("[[\"X\",\".\",\".\",\"X\"],[\".\",\".\",\".\",\"X\"],[\".\",\".\",\".\",\"X\"]]")));
    }
}
