package wang.tyrael.leetcode.BricksFalling803;

public class Solution {
    //2进制0000 左上右下
    int[][] mark;

    static int bottom = 0x1;
    static int right = 0x2;
    static int top = 0x4;
    static int left = 0x8;


    public int[] hitBricks(int[][] grid, int[][] hits) {
        for (int i = 0; i < hits.length; i++) {
            int[] item = hits[i];


        }

//        for (int i = 0; i < grid.length; i++) {
//            int[] item = grid[i];
//            //最左一行不需要依赖
//            mark[i][0] = left;
//            for (int j = 1; j < item.length; j++) {
//                //第一行
//                if(i == 0){
//                    if(item[j-1] == 1){
//                        mark[i][j] |= left;
//                    }else{
//                        //断了下一行
//                        continue;
//                    }
//                }else{
//                    //是否可以依赖左边的。
//                    if(item[j-1] == 1 && mark[i][j-1] != 0){
//                        mark[i][j] |= left;
//                    }
//                    //是否可以依赖上面的。
//                    if(grid[i-1][j] == 1 && mark[i-1][j] != 0){
//                        mark[i][j] |= top;
//                    }
//
//
//                }
//
//
//
//            }
//        }


        return new int[1];
    }

    public int hitBricks(int[][] grid, int[] hit) {

        return 0;
    }
}
