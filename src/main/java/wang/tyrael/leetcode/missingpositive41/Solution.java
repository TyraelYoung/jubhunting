package wang.tyrael.leetcode.missingpositive41;



public class Solution {
    public int firstMissingPositive(int[] nums) {
        int flagFound = 0;
        int flagNotFound = -1;
        for (int i = 0; i < nums.length; i++) {
           int value = nums[i];
           if (value == flagFound){
               nums[i] = -1;
           }
        }
        //ArrayUtil.printArray(nums);
        System.out.println();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (value > nums.length || value <= 0){

            }else{
                //value属于1-n，对结果有影响
                int temp = nums[value-1];
                nums[value-1] = flagFound;
                while(temp > 0 && temp <= nums.length){
                    value = temp;
                    temp = nums[value-1];
                    nums[value-1] = flagFound;
                }
            }
        }
        //ArrayUtil.printArray(nums);
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (value != flagFound){
                return i+1;
            }
        }
        return nums.length + 1;

    }
}
