package wang.tyrael.lintcode.design.tictactoe746;

/**
 * @Auther: wangchao
 * @Date: 2018/7/10 11:57
 * @Description:
 */
public class TicTacToe {
    int[][] borad = new int[3][3];
    boolean isATurn = true;
    boolean isEnd;

    public void move(int row, int column){
        if (borad[row][column] != 0) throw new AlreadyTakenException();
        if (isEnd) throw new GameEndException();
        int mark;
        if (isATurn) mark = 1;
        else mark = 2;
        borad[row][column] = mark;
        //行
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            if (borad[row][i] == mark) sum++;
        }
        if (sum == 3) {
            isEnd = true;
            if (isATurn) System.out.println("x player wins!");
            else System.out.println("o player wins!");
            return;
        }
        //列
        sum = 0;
        for (int i = 0; i < 3; i++) {
            if (borad[i][column] == mark) sum++;
        }
        if (sum == 3) {
            isEnd = true;
            if (isATurn) System.out.println("x player wins!");
            else System.out.println("o player wins!");
            return;
        }
        //对角线
        sum = 0;
        if (row == column){
            for (int i = 0; i < 3; i++) {
                if (borad[i][i] == mark) sum++;
            }
        }else if( row +column == 2){
            for (int i = 0; i < 3; i++) {
                if (borad[2-i][i] == mark) sum++;
            }
        }
        if (sum == 3) {
            isEnd = true;
            if (isATurn) System.out.println("x player wins!");
            else System.out.println("o player wins!");
            return;
        }
        isATurn = !isATurn;

    }
}
