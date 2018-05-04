package wang.tyrael.leetcode;


//Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].
//
//        You need to return the number of important reverse pairs in the given array.
//
//        Example1:
//
//        Input: [1,3,2,3,1]
//        Output: 2
//        Example2:
//
//        Input: [2,4,3,5,1]
//        Output: 3
//        Note:
//        The length of the given array will not exceed 50,000.
//        All the numbers in the input array are in the range of 32-bit integer.

public class ReversePairs493 {
    public static void main(String args[]){
        ReversePairs493 reversePairs493 = new ReversePairs493();

        int result = 0;
        result = reversePairs493.reversePairs(new int[]{1,3,2,3,1});
        System.out.println("{1,3,2,3,1}:" + 2 + ":" + result);

        result = reversePairs493.reversePairs(new int[]{2,4,3,5,1});
        System.out.println("[2,4,3,5,1]:" + 3 + ":" + result);

        result = reversePairs493.reversePairs(new int[]{2,1});
        System.out.println("[2,1]:" + 0 + ":" + result);

        result = reversePairs493.reversePairs(new int[]{3,1,1});
        System.out.println("[3,1,1]:" + 2 + ":" + result);

        result = reversePairs493.reversePairs(new int[]{});
        System.out.println("[]:" + 0 + ":" + result);

        result = reversePairs493.reversePairs(new int[]{2147483647,2147483647,2147483647,2147483647,2147483647,2147483647});
        System.out.println("[]:" + 0 + ":" + result);


    }

    /**
     * 暴力 n平方
     * 二分归并排序，减少比较次数
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        return reversePairsAndSortRecur(nums,0, nums.length-1);
    }

    /**
     *
     * @param src 无序数组
     * @param start 第一个数
     * @param stop 最后一个数
     * @return 本轮组间的逆序数
     */
    public int reversePairsAndSortRecur(int[] src, int start, int stop){
        if(start == stop){
            return 0;
        }
        //先看子数组，对子数组排序，并查看组内逆序数
        int mid = (stop -start) /2 + start;
        int resultLeft = reversePairsAndSortRecur(src, start, mid);
        int resultRight = reversePairsAndSortRecur(src, mid+1, stop);

        //处理组间问题
        int thisSum = reversePairsAndSortOnce(src, start, mid+1, stop);
        return resultLeft + resultRight + thisSum;
    }

    /**
     *
     * @param src 子数组已排序
     * @param start
     * @param mid 右侧第一个数
     * @param stop
     * @return 本轮组间的逆序数
     */
    public int reversePairsAndSortOnce(int[] src, int start, int mid, int stop){
        int[] left = new int[mid -start];
        int[] right = new int[stop -mid +1];
        for(int i=0; i<left.length; i++){
            left[i] = src[start + i];
        }
        for(int j=0; j<right.length; j++){
            right[j] = src[mid +j];
        }


        //计算逆序数
        //只需要看组间。
        int thisSum = 0;
        //i,j  同时往后推，在on时间计数结束
        int j = mid;
        for(int i=start; i<=mid-1; i++){
            //找到第一个 》= value/2的树，则前面的数都较小
            while(j <= stop && src[i] > src[j] *2L){
                j++;
            }
            thisSum += j -mid;

        }

        //归并排序
        int leftToOp = left.length -1;
        int rightToOp = right.length -1;
        int dstSpace = stop;
        while(leftToOp >= 0 && rightToOp >= 0){
            if(left[leftToOp] >= right[rightToOp]){
                src[dstSpace] = left[leftToOp];
                leftToOp --;
            }else{
                src[dstSpace] = right[rightToOp];
                rightToOp --;
            }
            dstSpace --;
        }

        while(leftToOp >= 0){
            src[dstSpace] = left[leftToOp];
            leftToOp --;
            dstSpace --;
        }

        while(rightToOp >= 0){
            src[dstSpace] = right[rightToOp];
            rightToOp -- ;
            dstSpace --;
        }



        return thisSum;
    }

}
