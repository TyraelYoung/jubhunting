package wang.tyrael.leetcode.array.sum3closet16;

import java.util.Arrays;

/**
 * @author: wangchao
 * 2018/5/4 0004
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3){
            return 0;
        }
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int one = nums[i];
            int otherCloset = target- one;
            int smallIndex = 0, bigIndex = nums.length-1;
            if (smallIndex == i){
                smallIndex++;
            }
            if (bigIndex == i){
                bigIndex--;
            }
            while (smallIndex < bigIndex){
                int thisDiff = otherCloset - nums[smallIndex] - nums[bigIndex];
//                System.out.println("thisDiff:" + thisDiff);
                if (Math.abs(thisDiff) < Math.abs(minDiff)){
                    minDiff = thisDiff;
                }
                if (thisDiff == 0){
                    //已经发现最小差值
                    return target;
                }else if (thisDiff > 0){
                    smallIndex++;
                }else{
                    bigIndex--;
                }
                if (smallIndex == i){
                    smallIndex++;
                }
                if (bigIndex == i){
                    bigIndex--;
                }
            }
        }
        return target - minDiff;
    }
}
