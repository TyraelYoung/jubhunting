package wang.tyrael.basic.sort;

/**
 * @Auther: wangchao
 * @Date: 2018/6/17 20:25
 * @Description:
 */
public class QuickSort {
    final int[] a;

    public QuickSort(int[] a) {
        this.a = a;
    }

    public void sort(){
        if (a == null || a.length < 2){
            return;
        }
        sort(0, a.length-1);
    }

    private void sort(int start, int end){
        if (start >= end){
            return;
        }
        int pivotIndex = partition(start, end);
        sort(start, pivotIndex-1);
        sort(pivotIndex+1, end);
    }

    private int partition(int start, int end){
        int pivot = a[start];
        int left = start, right = end;
        while (left < right){
            while (left < right && a[right] >= pivot) right--;
            //a[right] < pivot
            if (left < right)  a[left] = a[right];
            while(left < right && a[left] <= pivot) left++;
            if (left < right) a[right] = a[left];
        }
        a[left] = pivot;
        return left;
    }
}
