package wang.tyrael.leetcode.randompick398;

import java.util.Random;

/**
 * @author: wangchao
 * 2018/4/17 0017
 */
public class Solution {
    int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int result = -1;
        for (int i = 0, count = 0; i < nums.length; i++) {
            if (nums[i] == target){
                count ++;
                Random random = new Random();
                //0-count
                int r = random.nextInt(count);
                if (r+1 <= 1){
                    result = i;
                }
            }
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */