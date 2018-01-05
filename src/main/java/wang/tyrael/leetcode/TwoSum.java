package wang.tyrael.leetcode;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:
 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 */
public class TwoSum {
    public static void main(String[] args){
        int[] nums = new int[]{2, 7, 11, 15};
        int[] result = new TwoSum().twoSum(nums, 9);
        System.out.println("result[0]:" + result[0]);
        System.out.println("result[1]:" + result[1]);
        //正常开关没有打开
        assert result[0] == 1;
        assert result[1] == 1;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0; i< nums.length; i++){
            int one = nums[i];
            for(int j=0; j <nums.length; j++){
                if(i == j){
                    continue;
                }
                int two = nums[j];
                if(one + two == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}
