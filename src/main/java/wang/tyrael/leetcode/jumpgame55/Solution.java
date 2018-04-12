package wang.tyrael.leetcode.jumpgame55;

/**
 * @author: wangchao
 */
public class Solution {
    public boolean canJump(int[] nums) {
        int next = 0;
        while (true){
            //贪心，选下一个点
            int cur = next;
            if (cur >= nums.length-1){
                return true;
            }
            if (nums[cur] == 0){
                return false;
            }
            //至少可以跳到下一个点
            next = cur+1;
            //最多可以跳到cur+nums[i]
            for (int i = cur +2; i < nums.length && i <= cur + nums[cur]; i++) {
                if(i + nums[i] > next + nums[next]){
                    //选一个可以跳的最远的点
                    next = i;
                }
            }
        }

    }
}