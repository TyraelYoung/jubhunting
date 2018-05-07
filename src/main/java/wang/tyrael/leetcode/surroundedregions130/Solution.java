package wang.tyrael.leetcode.surroundedregions130;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: wangchao
 */
public class Solution {
    //搜索所有边缘的o
    class Pair{
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    Queue<Pair> toExtend = new LinkedList<>();

    char[][] board;
    int height, width;

    static char MARK = 'A';

    public void solve(char[][] board) {
        this.board = board;
        height = board.length;
        if (height == 0){
            return;
        }
        width = board[0].length;
        if (width == 0){
            return;
        }
        initQueue(board);
        process();
        format();
    }

    private void format() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == MARK){
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void process() {
        Pair pair = toExtend.poll();
        while (pair != null){
            //四个方向处理一下
            //left
            if (pair.x -1 >= 0 && board[pair.x-1][pair.y] == 'O'){
                board[pair.x-1][pair.y] = MARK;
                toExtend.add(new Pair(pair.x-1, pair.y));
            }
            //up
            if (pair.y -1 >= 0 && board[pair.x][pair.y-1] == 'O'){
                board[pair.x][pair.y-1] = MARK;
                toExtend.add(new Pair(pair.x, pair.y-1));
            }
//right
            if (pair.x +1 <height && board[pair.x+1][pair.y] == 'O'){
                board[pair.x+1][pair.y] = MARK;
                toExtend.add(new Pair(pair.x+1, pair.y));
            }
//down
            if (pair.y +1 < width && board[pair.x][pair.y+1] == 'O'){
                board[pair.x][pair.y+1] = MARK;
                toExtend.add(new Pair(pair.x, pair.y +1));
            }

            pair = toExtend.poll();
        }
    }

    void initQueue(char[][] board){
        //up
        for (int i = 0; i < width; i++) {
            if (board[0][i] == 'O'){
                board[0][i] = MARK;
                toExtend.add(new Pair(0, i));
            }
        }
        //right
        for (int i = 0; i < height; i++) {
            if (board[i][width-1] == 'O'){
                board[i][width-1] = MARK;
                toExtend.add(new Pair(i, width-1));
            }
        }
        //down
        for (int i = 0; i < width; i++) {
            if (board[height-1][i] == 'O'){
                board[height-1][i] = MARK;
                toExtend.add(new Pair(height-1, i));
            }
        }
        //left
        for (int i = 0; i < height; i++) {
            if (board[i][0] == 'O'){
                board[i][0] = MARK;
                toExtend.add(new Pair(i, 0));
            }
        }

    }
}
