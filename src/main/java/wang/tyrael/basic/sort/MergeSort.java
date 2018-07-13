package wang.tyrael.basic.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Auther: wangchao
 * @Date: 2018/6/17 20:47
 * @Description:
 */
public class MergeSort {
    final int[] a;

    public MergeSort(int[] a) {
        this.a = a;
    }

    public void sort(){
        if (a == null || a.length < 2){
            return;
        }
        sort(0, a.length-1);
    }
/*/*/
    private void sort(int begin, int end){
        if (begin >= end) return;
        int mid = begin + ((end -begin)>>1);
        sort(begin, mid);
        sort(mid+1, end);
        //归并
        int[] sub1 = Arrays.copyOfRange(a, begin, mid +1);
        int[] sub2 = Arrays.copyOfRange(a, mid+1, end+1);
        int i = 0, iEnd = mid-begin,
                j = 0, jEnd = end - mid -1, aIndex= begin;
        while (i <= iEnd && j<=jEnd){
            if (sub1[i] < sub2[j]) a[aIndex++] = sub1[i++];
            else a[aIndex++] = sub2[j++];
        }
        while (i <= iEnd) a[aIndex++] = sub1[i++];
        while (j <= jEnd) a[aIndex++] = sub2[j++];
    }
}
