package wang.tyrael;

import java.util.Arrays;

public class ArrayUtil {
    public static void printArray(int[] n){
        for(int i :n){
            System.out.print("" + i + ",");
        }
    }

    private void testBinSearchBig(){
        int[] nums = new int[]{1,3,2,3,1};
        Arrays.sort(nums);
        printArray(nums);
        int result = binSearchBig(nums, 2, 3, 1);
        System.out.println("****************");
        System.out.println(result);
    }



    /**
     * 从前往后，找到第一个比key大或者=的数
     * 则，前面的数，都比key小
     * TODO 改用二分查找
     * @param nums 要求已排序
     * @param start
     * @param stop
     * @param key
     * @return 如果所有数都小于key，则返回stop+1
     */
    private int binSearchBig(int[] nums, int start, int stop, double key){
        if(start == stop){
            if(nums[start] >= key){
                return start;
            }else{
                return stop+1;
            }
        }
        int mid = (stop - start)/2 + start;
        if(nums[mid] == key){
            //可疑值在mid左边，包含
            while (mid >= start){
                mid--;
                if(nums[mid] < key){
                    return mid +1;
                }
            }
            if(mid == start-1){
                return start;
            }
        }
        if(nums[mid] > key){
            //可疑值在mid左边，包含
            int result = binSearchBig(nums, start, mid, key);
            return result;
        }else{
            //可疑值在mid右边，不包含

            return binSearchBig(nums, mid+1, stop, key);
        }
    }
}
