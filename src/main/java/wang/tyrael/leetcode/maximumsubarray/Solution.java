package wang.tyrael.leetcode.maximumsubarray;

public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int edge =Integer.MIN_VALUE,
                max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (edge > 0){
                edge += x;
            }else{
                edge = x;
            }

            if(edge > max){
                max = edge;
            }
        }
        return max;
    }
}
