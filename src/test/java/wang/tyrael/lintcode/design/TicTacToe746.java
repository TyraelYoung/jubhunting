package wang.tyrael.lintcode.design;

import org.junit.Test;
import wang.tyrael.lintcode.design.tictactoe746.TicTacToe;

/**
 * @Auther: wangchao
 * @Date: 2018/7/10 14:01
 * @Description:
 */
public class TicTacToe746 {
    @Test
    public void test(){
        TicTacToe t = new TicTacToe();
        t.move(0, 0); // X turn
        t.move(1, 0); // O trun
        t.move(1, 1); // X turn
        t.move(2, 0); // O turn
        t.move(2, 2); // X turn and win
        t.move(0, 0); //throw GameEndException

    }

    @Test
    public void test1(){
        TicTacToe t = new TicTacToe();
        t.move(0, 0); // X turn
        try{
            t.move(0, 0); // throw AlreadyTakenException
        }catch (Exception e){

        }

        t.move(1, 0); // O turn
        t.move(1, 1); // X turn
        t.move(2, 0);// o turn
        t.move(2, 2); // X turn and win
    }
}
