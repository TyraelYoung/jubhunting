package wang.tyrael.leetcode.matrix.tictactoe.validtictactoe794;

/**
 * 1. x比o多1，或者相等
 * 2. 最多存在一个3连.如果存在交叉，可以存在两个3连
 * 3. 如果x赢，则x比o多1；如果O赢，则相等。
 * @Auther: wangchao
 * @Date: 2018/7/11 16:17
 * @Description:
 */
public class Solution {
    public boolean validTicTacToe(String[] board) {
        int countX = 0, countO = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                switch (board[i].charAt(j)){
                    case 'X':
                        countX++;
                        break;
                    case 'O':
                        countO++;
                        break;
                }
            }
        }
        if (countX != countO && countX-countO != 1){
            return false;
        }
        //检查3连
        int countTripleRow = 0;
        char winner = 0;
        if (countX < 3 && countO < 3) return true;
        for (int i = 0; i < board.length; i++) {
            if (board[i].charAt(0) == board[i].charAt(1) && board[i].charAt(1) == board[i].charAt(2)){
                winner = board[i].charAt(0);
                countTripleRow++;
                if (countTripleRow > 1) return false;
            }
        }
        int countTipleColumn = 0;
        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(i) == board[1].charAt(i) && board[1].charAt(i) == board[2].charAt(i)){
                winner = board[0].charAt(i);
                countTipleColumn++;
                if (countTipleColumn > 1) return false;
            }
        }


        if (board[0].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(2)){
            winner = board[1].charAt(1);
        }
        if (board[0].charAt(2) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(0)){
            winner = board[1].charAt(1);
        }
        if (winner == 'X' ){
            return countX > countO;
        }
        if (winner == 'O'){
            return countX == countO;
        }

        return true;
    }
}
