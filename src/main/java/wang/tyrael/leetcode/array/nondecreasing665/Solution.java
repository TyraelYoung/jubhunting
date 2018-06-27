package wang.tyrael.leetcode.array.nondecreasing665;

/**
 * @Auther: wangchao
 * @Date: 2018/6/26 09:42
 * @Description:
 */
public class Solution {
    public boolean checkPossibility(int[] nums) {
        if (nums == null) return false;
        if(nums.length <= 2) return true;
        //找到第一个逆序
        int leftIndex = 0, rightIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            leftIndex = i-1;
            rightIndex = i;
            if (nums[leftIndex] <= nums[rightIndex]) continue;
            break;
        }

        int leftEdge = 0, rightEdge = 0;
        if (leftIndex == 0) leftEdge = Integer.MIN_VALUE;
        else leftEdge = nums[leftIndex-1];
        if (rightIndex == nums.length-1) rightEdge = Integer.MAX_VALUE;
        else rightEdge = nums[rightIndex +1];

        //尝试修改左边的数
        if (leftEdge > nums[rightIndex]){
            //尝试修改右边的数
            if (nums[leftIndex] > rightEdge){
                return false;
            }
        }
        //修改成功
        leftIndex = rightIndex;
        for (int i = leftIndex +1; i < nums.length; i++) {
            leftIndex = i-1;
            rightIndex = i;
            if (nums[leftIndex] > nums[rightIndex]) return false;
        }
        return true;
    }
}
