package wang.tyrael.leetcode.math.productsubarray152;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: wangchao
 * 2018/5/3 0003
 */
public class Solution {
    public int maxProduct(int[] nums) {
         int result = maxProduct(nums, 0, nums.length-1);
        return result == Integer.MIN_VALUE ? 0: result;
    }

    public int maxProduct(int[] nums, int start, int end) {
        if (start > end){
            return Integer.MIN_VALUE;
        }
        if (start == end){
            return nums[start];
        }
        int product = 1;
        for (int i = start; i <= end; i++) {
            product *= nums[i];
        }
        if (product == 0){
            List<Integer> candidates = new ArrayList<>();
            candidates.add(0);
            int pre0 = start-1;
            for (int i = start; i <= end; i++) {
                if (nums[i] == 0){
                    candidates.add(maxProduct(nums, pre0+1, i-1));
                    pre0 = i;
                }
            }
            candidates.add(maxProduct(nums, pre0+1, end));
            candidates.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 > o2? -1: 1;
                }
            });
            return candidates.get(0);
        }else if(product < 0){
            int leftNegtive = 0, rightNegtive = 0;
            for (int i = start; i <= end; i++) {
                if (nums[i] < 0){
                    leftNegtive = i;
                    break;
                }
            }
            for (int i = end; i >= start ; i--) {
                if (nums[i] < 0){
                    rightNegtive = i;
                    break;
                }
            }
            int pRight = 1, pLeft = 1;
            for (int i = leftNegtive+1; i <= end ; i++) {
                pRight *= nums[i];
            }
            for (int i = start; i < rightNegtive; i++) {
                pLeft *= nums[i];
            }
            return pLeft < pRight? pRight : pLeft;
        }else{
            return product;
        }
    }
}
