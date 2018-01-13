package wang.tyrael.leetcode;

public class MinimumPathSum64 {
    public static void main(String[] args){
        MinimumPathSum64 minimumPathSum64 = new MinimumPathSum64();
        int result;
        result = minimumPathSum64.minPathSum(new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}});
        System.out.println("7:" + result);
    }

    public int minPathSum(int[][] grid) {
        int rowCount = grid.length;
        int columnCount = grid[0].length;
        int min[][] = new int[rowCount][columnCount];

        min[rowCount-1][columnCount-1] = grid[rowCount-1][columnCount-1];
        //构造矩阵
        //最后一行到第一行
        int i = rowCount-1;
        for(int j = columnCount-2; j >=0; j--){
            //最后一行
            min[i][j] = grid[i][j] + min[i][j+1];
        }
        //最后一列
        int j = columnCount-1;
        for(i = rowCount-2; i>=0; i--){
            min[i][j] = grid[i][j] + min[i+1][j];
        }

        for (i = rowCount-2; i >= 0; i--){
            for(j = columnCount-2; j >=0; j--){
                if(min[i+1][j] > min[i][j+1]){
                    min[i][j] = grid[i][j] + min[i][j+1];
                }else{
                    min[i][j] = grid[i][j] + min[i+1][j];
                }
            }
        }

        return min[0][0];

    }
}
