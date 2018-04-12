package wang.tyrael.leetcode.KthSmallest719;

import java.util.Arrays;

/**
 * 接触pq实现大根堆
 */
public class Solution {

    /**
     *
     * This is because the binary search always finds the smallest mi that satisfies count>=k.
     * Imagine when we find a large mi with count >= k, hi is set to mi, and we keep looking to the left.

     I
     icesnakejin commented 5 months ago
     Thank you for the post, really clear and logical. I just have a small question that for the mi , how do you guarantee there will be a distance equals to the mi ?

     int mi = (lo + hi) / 2; it's not the actual distance,
     * @param nums
     * @param k
     * @return
     */
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int maxDiff = nums[nums.length-1] - nums[0];
        int high = maxDiff, low = 0;
        int mid = 0;

        while(low < high){
            mid = low + (high - low)/2;
            //巧妙的点<k
            if(countPairs(nums, mid) < k){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return low;

    }

    private int countPairs(int[] a, int mid){
        int n = a.length, result = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            for (; j < n; j++) {
                if(a[j] - a[i] > mid){
                    break;
                }
            }
            result += j-i-1 ;
        }
        return result;
    }
}