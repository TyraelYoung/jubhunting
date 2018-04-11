package wang.tyrael;

/**
 * 小根堆
 */
public class HeapSort {
    public static void adjust(int[] a, int start, int end) {
        //左孩子
        int top = a[start];
        int i;
        for (i = 2 * start + 1; i <= end; i = 2 * (i + 1)) {
            //i 较小的孩子
            int min = i;
            if (i+1<= end && a[i] > a[i + 1]) {
                min = i + 1;
            }
            if (a[min] < top) {
                //较小的值上浮
                a[(i-1)/2] = a[min];
            } else {
                a[(i-1)/2] = top;
                return;
            }
        }
        a[(i-1)/2] = top;
    }

    public static void init(int[] a){
        for (int i = a.length /2 -1; i >= 0; i--) {
            adjust(a, i, a.length-1);
        }
    }

    /**
     * 从大到小排队
     * @param a
     */
    public static void sort(int[] a){
        init(a);
        ArrayUtil.printArray(a);
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            int temp = a[a.length-1-i];
            a[a.length -1 -i] = a[0];
            a[0] = temp;
            adjust(a, 0, a.length-1-i-1);
        }
    }

}
