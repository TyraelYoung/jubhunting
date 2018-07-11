package wang.tyrael.lintcode.matrix.battleships986;

/**
 * @Auther: wangchao
 * @Date: 2018/7/11 15:18
 * @Description:
 */
public class Solution {
    /**
     * @param board: the given 2D board
     * @return: the number of battle ships
     */
    public int countBattleships(char[][] board) {
        // Write your code here
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            //左边是否是军舰的一部分, 每一行开始，左边必然不是。
            boolean isLeftPart = false;
            for (int j = 0; j < board[0].length; j++) {
                //当前点非军舰
                if (board[i][j] == '.') {
                    isLeftPart = false;
                    continue;
                }
                //当前点是军舰
                //左边已经统计过了
                if (isLeftPart) continue;
                //下一个点做准备
                isLeftPart = true;
                //最后一行
                if (i == board.length -1){
                    count++;
                    continue;
                }
                //非最后一行，查看军舰是否到尾部了。
                if (board[i+1][j] == '.'){
                    count++;
                    continue;
                }

            }
        }
        return count;
    }
}
