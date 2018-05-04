package wang.tyrael.leetcode;

import java.util.ArrayList;
import java.util.List;

//In a N x N grid representing a field of cherries, each cell is one of three possible integers.
//
//        0 means the cell is empty, so you can pass through;
//        1 means the cell contains a cherry, that you can pick up and pass through;
//        -1 means the cell contains a thorn that blocks your way.
//        Your task is to collect maximum number of cherries possible by following the rules below:
//
//        Starting at the position (0, 0) and reaching (N-1, N-1) by moving right or down through valid path cells (cells with value 0 or 1);
//        After reaching (N-1, N-1), returning to (0, 0) by moving left or up through valid path cells;
//        When passing through a path cell containing a cherry, you pick it up and the cell becomes an empty cell (0);
//        If there is no valid path between (0, 0) and (N-1, N-1), then no cherries can be collected.
//        Example 1:
//        Input: grid =
//        [[0, 1, -1],
//        [1, 0, -1],
//        [1, 1,  1]]
//        Output: 5
//        Explanation:
//        The player started at (0, 0) and went down, down, right right to reach (2, 2).
//        4 cherries were picked up during this single trip, and the matrix becomes [[0,1,-1],[0,0,-1],[0,0,0]].
//        Then, the player went left, up, up, left to return home, picking up one more cherry.
//        The total number of cherries picked up is 5, and this is the maximum possible.
//        Note:
//
//        grid is an N by N 2D array, with 1 <= N <= 50.
//        Each grid[i][j] is an integer in the set {-1, 0, 1}.
//        It is guaranteed that grid[0][0] and grid[N-1][N-1] are not -1
public class CherryPickup741 {
    public static void main(String[] args){
        CherryPickup741 cherryPickup741 = new CherryPickup741();
        int result;
        result = cherryPickup741.cherryPickup(new int[][]{{0, 1, -1},
 {1, 0, -1},
 {1, 1,  1}});
        System.out.println("5:" + result);



        result = cherryPickup741.cherryPickup(new int[][]{{1,1,-1},{1,-1,1},{-1,1,1}});
        System.out.println("0:" + result);

        result = cherryPickup741.cherryPickup(new int[][]{
                {1,-1,1,-1,1,1,1,1,1,-1},
                {-1,1,1,-1,-1,1,1,1,1,1},
                {1,1,1,-1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1},
                {-1,1,1,1,1,1,1,1,1,1},
                {1,-1,1,1,1,1,-1,1,1,1},
                {1,1,1,-1,1,1,-1,1,1,1},
                {1,-1,1,-1,-1,1,1,1,1,1},
                {1,1,-1,-1,1,1,1,-1,1,-1},
                {1,1,-1,1,1,1,1,1,1,1}
        }
);
        System.out.println("0:" + result);

        result = cherryPickup741.cherryPickup(new int[][]{
                        {1,-1,1},
                        {-1,1,1},
                        {1,1,1}
                }
        );
        System.out.println("0:" + result);

        result = cherryPickup741.cherryPickup(new int[][]{
                        {1,-1},
                        {-1,1}
                }
        );
        System.out.println("0:" + result);
    }

    /**
     * 两个路程-》两个人
     * @param grid
     * @return
     */
    public int cherryPickup(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;

        int option[][][] = new int[row + column -1][row][row];
        option[0][0][0] = grid[0][0];
        /**
         * 每一步
         * A与B只能同时到达某个点，不存在先后到达
         */
        for(int step=0; step<row+column-1; step++){
            for(int r1 =0; r1 < row; r1 ++){
                for(int r2 =0; r2< row; r2++){
                    if(r1 > step || r2>step){
                        option[step][r1][r2] = -1;
                        continue;
                    }

                    int column1 = step -r1;
                    if(column1 >= column){
                        option[step][r1][r2] = -1;
                        continue;
                    }
                    int column2 = step -r2;
                    if(column2 >= column){
                        option[step][r1][r2] = -1;
                        continue;
                    }
                    //在第step步，A处在r1行，B处在r2行
                    //这个点，最大值是？

                    if(grid[r1][step-r1] == -1 || grid[r2][step-r2] == -1){
                        option[step][r1][r2] = -1;
                        continue;
                    }

                    int thisStep;
                    if(r1 == r2){
                        thisStep = grid[r1][step-r1];
                    }else{
                        thisStep = grid[r1][step-r1] + grid[r2][step-r2];
                    }
                    //为了到达该点，上一步两人的位置
                    //option[step-1][r1][r2]
                    //option[step-1][r1-1][r2]
                    //option[step-1][r1][r2-1]
                    //option[step-1][r1-1][r2-1]
                    List<Integer> candidate = new ArrayList<>();
                    if(step == 0){
                        //第一个格子，已初始化
                        continue;
                    }
                    if(option[step-1][r1][r2] != -1){
                        candidate.add(option[step-1][r1][r2]);
                    }
                    if(r1 > 0 && option[step-1][r1-1][r2] != -1){
                        candidate.add(option[step-1][r1-1][r2]);
                    }
                    if(r2 > 0 && option[step-1][r1][r2-1] != -1){
                        candidate.add(option[step-1][r1][r2-1]);
                    }
                    if(r1>0 && r2>0 && option[step-1][r1-1][r2-1] !=-1){
                        candidate.add(option[step-1][r1-1][r2-1]);
                    }
                    if(candidate.isEmpty()){
                        option[step][r1][r2] =-1;
                    }else{
                        int max = MathUtil.max(candidate);
                        option[step][r1][r2] = thisStep + max;
                    }
                }
            }
        }
        return option[row + column -1-1][row-1][row-1]>=0? option[row + column -1-1][row-1][row-1]:0;
    }

    public static class MathUtil {
        public static int max(int[] candidate){
            int max = Integer.MIN_VALUE;
            for(int i=0; i< candidate.length; i++){
                if(max < candidate[i]){
                    max = candidate[i];
                }
            }
            return max;
        }

        public static int max(List<Integer> candidate){
            int max = Integer.MIN_VALUE;
            for(int i=0; i< candidate.size(); i++){
                if(max < candidate.get(i)){
                    max = candidate.get(i);
                }
            }
            return max;
        }
    }
}


