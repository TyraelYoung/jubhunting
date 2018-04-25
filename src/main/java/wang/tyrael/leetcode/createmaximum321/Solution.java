package wang.tyrael.leetcode.createmaximum321;

public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
//        max(nums1, nums2, k, 0, 0, new int[k]);


        int startLimit1 = 0,
                startLimit2 = 0,
                //inclusive
                endLimit1 = 0,
                endLimit2 = 0,
                n1 = nums1.length,
                n2 = nums2.length,
                countFound = 0;

        for (int i = 0; i < k; i++) {
            int countLeft1 = n1 - startLimit1 -1;
            int countLeft2 = n2 - startLimit2 -1;
            int countKLeft = k - countFound;
            if (countKLeft > countLeft1){
                endLimit2 = countLeft2 - (countKLeft - countLeft1);
            }
            if(countKLeft > countLeft2){
                endLimit1 = countLeft1 - (countKLeft - countLeft2);
            }
            
            //在限制中选一个最大的数
            int max = Integer.MAX_VALUE;
            for (int j = startLimit1; j < endLimit1 +1; j++) {

            }


        }

        return result;
    }

//    void max(int[] nums1, int[] nums2, int k, int startLimit1, int startLimit2, int[] result){
//
//    }
}
