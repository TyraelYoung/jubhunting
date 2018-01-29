package wang.tyrael.leetcode.candy135;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间复杂度：n
 */
public class Solution {
    public int candy(int[] ratings) {
        if(ratings.length == 1){
            return 1;
        }
        int[] candy = new int[ratings.length];
        //低点
        List<Integer> lows = new ArrayList<>();
        if(ratings[0] <= ratings[1]){
            lows.add(0);
        }
        for (int i = 1; i < ratings.length-1; i++) {
            if(ratings[i] <= ratings[i-1] && ratings[i] <= ratings[i+1]){
                lows.add(i);
            }
        }
        if(ratings[ratings.length-1] <= ratings[ratings.length-2]){
            lows.add(ratings.length-1);
        }

        for(int i : lows){
            candy[i] =1;
            //求这个波谷的值，从波底往两边
            //往前
            if(i != 0){
                for (int j = i-1; j >=0 ; j--) {

                    if(ratings[j] > ratings[j+1]){
                        int more = candy[j+1] + 1;
                        if(candy[j] > more){
                            //上一个低点上升来的最大值，比较大

                        }else{
                            candy[j] = more;
                        }
                    }else{
                        //已经过了高点
                        break;
                    }
                }
            }
            if(i != ratings.length -1){
                //往后
                for (int j = i+1; j < ratings.length; j++) {
                    if(ratings[j] > ratings[j-1]){
                        int more = candy[j-1] +1;
                        candy[j] = more;
                    }else{
                        break;
                    }
                }
            }
        }

        int sum =0;
        for (int i:candy){
            sum += i;
        }
        return sum;
    }
}
