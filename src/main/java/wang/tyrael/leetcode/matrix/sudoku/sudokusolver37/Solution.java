package wang.tyrael.leetcode.matrix.sudoku.sudokusolver37;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangchao
 * 2018/4/27 0027
 */
public class Solution {
    public void solveSudoku(char[][] board) {
        doSolveSudoku(board);
    }

    public boolean doSolveSudoku(char[][] board) {
        Point point = findEmpty(board);
        if (point == null){
            //递归完成出口
            return true;
        }
        List<Character> squareMiss = getMissingFromSqure(board, point.x, point.y);
        List<Character> rowMiss = getMissingFromRow(board, point.x, point.y);
        List<Character> columnMiss = getMissingFromColumn(board, point.x, point.y);
        List<Character> inter = intersect(squareMiss, rowMiss, columnMiss);
        for (Character i :
                inter) {
            board[point.y][point.x] = i;
            //递归
            boolean result = doSolveSudoku(board);
            if (result){
                //返回上层调用
                return true;
            }
            //尝试下一个
        }
        board[point.y][point.x] = '.';
        //所有的都尝试完了，还没有成功
//        System.out.println("return false:");
//        System.out.println("x:" + point.x + ",y:" + point.y + ":");
        return false;

    }

    public Point findEmpty(char[][] board){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.'){
                    return new Point(j, i);
                }
            }
        }
        return null;
    }

    public List<Character> intersect(List<Character> list, List<Character> list1, List<Character> list2){
        list.retainAll(list1);
        list.retainAll(list2);
        return list;
    }

    public List<Character> getMissingFromSqure(char[][] board, int x, int y){
        int iSqureStart = y /3 *3, jSqureStart = x /3 *3;
        List<Character> result = new ArrayList<>();
        for (char i = '1'; i <= '9'; i++) {
            boolean flagFound = false;
            //每一行
            for (int k = iSqureStart; k < iSqureStart+3; k++) {
                //每一列
                for (int j = jSqureStart; j < jSqureStart+3; j++) {
                    if (board[k][j] == i){
                        flagFound =true;
                    }
                }
            }
            if (!flagFound){
                result.add(i);
            }
        }
        return result;
    }

    public List<Character> getMissingFromRow(char[][] board, int x, int y){

        List<Character> result = new ArrayList<>();
        for (char i = '1'; i <= '9'; i++) {
            int j;
            for (j = 0; j < 9; j++) {
                if (board[y][j] == i) {
                    break;
                }
            }
            if (j == 9) {
                result.add(i);
            }
        }
//        System.out.println("x:" + x + ",y:" + y + ":");
//        ArrayUtil.print(result);
//        System.out.println();
//        System.out.println("x:" + x + ",y:" + y + ":");
        return result;
    }

    public List<Character> getMissingFromColumn(char[][] board, int x, int y){
        List<Character> result = new ArrayList<>();
        for (char i = '1'; i <= '9'; i++) {
            int j;
            for (j = 0; j < 9; j++) {
                if (board[j][x] == i) {
                    break;
                }
            }
            if (j == 9) {
                result.add(i);
            }
        }
        return result;
    }

    class Point {
        //列号
        public int x;
        //行号
        public int y;

        public Point() {
            x = 0;
            y = 0;
        }

        public Point(int a, int b) {
            x = a;
            y = b;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }

        @Override
        public int hashCode() {
            return toString().hashCode();
        }

    }

}
