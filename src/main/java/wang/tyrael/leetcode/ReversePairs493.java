package wang.tyrael.leetcode;

import java.util.Arrays;
import java.util.Collections;

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
    public int reversePairsAndSortLoop(int[] src, int start, int stop){
        return 0;
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
        int[] dst = new int[src.length];
        //计算逆序数
        //只需要看组间。
        int thisSum = 0;
        for(int i=mid-1; i>= start; i--){
            int leftValue = src[i];
            int index = binSearchBig(src, mid, stop, leftValue/2.0);
//            int index = searchBig(src, mid, stop, leftValue/2.0);
            if(index == mid){
                //不存在,下一个数不用再找了
                break;
            }else{
                //找到一个比当前数2倍小的数，则前面的数都较小。
                thisSum += index - mid;
            }
        }

        //归并排序
        int leftToOp = mid-1;
        int rightToOp = stop;
        int dstSpace = stop;
        while(leftToOp >= start && rightToOp >= mid){
            if(src[leftToOp] >= src[rightToOp]){
                dst[dstSpace] = src[leftToOp];
                leftToOp --;
            }else{
                dst[dstSpace] = src[rightToOp];
                rightToOp --;
            }
            dstSpace --;
        }

        while(leftToOp >= start){
            dst[dstSpace] = src[leftToOp];
            leftToOp --;
            dstSpace --;
        }

        while(rightToOp >= mid){
            dst[dstSpace] = src[rightToOp];
            rightToOp -- ;
            dstSpace --;
        }

        //排好序的数字填回原数组
        for (int i=start; i<= stop;i++){
            src[i] = dst[i];
        }

        return thisSum;
    }

    /**
     * 从前往后，找到第一个比key大的数
     * 则，前面的数，都比key小
     * TODO 改用二分查找
     * @param nums 要求已排序
     * @param start
     * @param stop
     * @param key
     * @return
     */
    private int searchBig(int[] nums, int start, int stop, double key){
        int j = 0;
        for(j=start; j<=stop; j++){
            if(nums[j] >= key){
                break;
            }
        }
        return j;
    }

    /**
     * 从前往后，找到第一个比key大的数
     * 则，前面的数，都比key小
     * TODO 改用二分查找
     * @param nums 要求已排序
     * @param start
     * @param stop
     * @param key
     * @return
     */
    private int binSearchBig(int[] nums, int start, int stop, double key){
        if(start == stop){
            if(nums[start] > key){
                return start;
            }else{
                return stop +1;
            }
        }
        int mid = (stop - start)/2 + start;
        if(nums[mid] == key){
            //可疑值在mid右边，不包含
            while (mid <= stop){
                mid++;
                if(nums[mid] > key){
                    return mid;
                }
            }
            //没找到
            return stop + 1;
        }
        if(nums[mid] > key){
            //可疑值在mid左边，包含
            return binSearchBig(nums, start, mid, key);
        }else{
            //可疑值在mid右边边，不包含
            return binSearchBig(nums, mid+1, stop, key);
        }
    }
}
