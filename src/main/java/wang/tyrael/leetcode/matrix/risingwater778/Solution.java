package wang.tyrael.leetcode.matrix.risingwater778;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: wangchao
 * 2018/5/2 0002
 */
public class Solution {
    int countTime = 0;
    int currentHeight = 0;
    boolean[][] visitedOrInQueue;

    PriorityQueue<RC> priorityQueue = new PriorityQueue<>(new Comparator<RC>() {
        @Override
        public int compare(RC o1, RC o2) {
            return o1.value-o2.value;
        }
    });

    public int swimInWater(int[][] grid) {
        int rHeight = grid.length;
        if (rHeight == 0){
            return 0;
        }
        int cWidth = grid[0].length;
        if (cWidth == 0){
            return 0;
        }
        RC.rHeight = rHeight;
        RC.cWidth = cWidth;
        visitedOrInQueue = new boolean[rHeight][cWidth];
        currentHeight = grid[0][0];
        priorityQueue.add(new RC(0, 0, grid[0][0]));
        while (!priorityQueue.isEmpty()){
            RC RC = priorityQueue.poll();
            if (RC.value <= currentHeight){
                //可以直接访问
            }else{
                //需要升高度
                countTime += RC.value -currentHeight;
                currentHeight = RC.value;
            }
            //访问
            if (RC.r == rHeight-1 && RC.c == cWidth-1){
                return countTime;
            }
            List<RC> neighbors = new ArrayList<>();
            neighbors.add(RC.left());
            neighbors.add(RC.right());
            neighbors.add(RC.up());
            neighbors.add(RC.down());
            for (RC n :
                    neighbors) {
                if (n == null){
                    continue;
                }
                if (visitedOrInQueue[n.c][n.r]){
                    continue;
                }
                n.value = grid[n.c][n.r];
                priorityQueue.add(n);
            }
        }
        return -1;
    }
}



/**
 * 行列号
 * @author: wangchao
 * 2018/4/28 0028
 */
class RC {
    public static int rHeight, cWidth;

    public int r, c, value;
    public RC(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public RC(int r, int c, int value) {
        this.r = r;
        this.c = c;
        this.value = value;
    }

    public RC left(){
        if (c-1 < 0){
            return null;
        }
        return new RC(r, c-1);
    }

    public RC right(){
        if (c+1 >= cWidth){
            return null;
        }
        return new RC(r, c+1);
    }

    public RC up(){
        if (r-1 <0){
            return null;
        }
        return new RC(r-1, c);
    }

    public RC down(){
        if (r+1 >= rHeight){
            return null;
        }
        return new RC(r+1, c);
    }

    @Override
    public String toString() {
        return "(" + r + "," + c +")";
    }
}

