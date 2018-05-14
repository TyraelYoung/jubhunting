package wang.tyrael.basic.binaryserach;

/**
 * 有序数组，返回序号相等的，最大的索引
 * @author: wangchao
 * 2018/5/14 0014
 */
public class MinGreater implements IBinarySearch {
    public int binarySearch(int[] arr, int needle){
        if (arr== null || arr.length == 0){
            return -1;
        }
        int low =0, high = arr.length-1, mid;
//最终high = low-1
        while (low <= high){
            mid = low + (high-low)/2;
            if (arr[mid] <= needle){
                low = mid +1;
            }else{
                high = mid-1;
            }
        }
        if (low >= arr.length){
            return -1;
        }
        return low;
    }
}
