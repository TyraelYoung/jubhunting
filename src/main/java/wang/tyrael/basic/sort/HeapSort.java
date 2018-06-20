package wang.tyrael.basic.sort;

public class HeapSort {
    final int[] a;

    public HeapSort(int[] a) {
        this.a = a;
    }

    /**
     * 大根堆
     * @param start
     * @param end
     */
    public void adjust(int start, int end) {
        //左孩子
        int top = a[start];
        int i;
        for (i = 2 * start + 1; i <= end; i = 2 * (i + 1)) {
            //i 较大的孩子
            int maxIndex = i;
            if (i+1<= end && a[i] < a[i + 1]) {
                maxIndex = i + 1;
            }
            if (a[maxIndex] > top) {
                //较大的值上浮
                a[(i-1)/2] = a[maxIndex];
            } else {
                a[(i-1)/2] = top;
                return;
            }
        }
        a[(i-1)/2] = top;
    }

    public void init(int[] a){
        for (int i = a.length /2 -1; i >= 0; i--) {
            adjust(i, a.length-1);
        }
    }

    /**
     * 从大到小排队
     */
    public void sort(){
        init(a);
        for (int i = 0; i < a.length; i++) {
            int temp = a[a.length-1-i];
            a[a.length -1 -i] = a[0];
            a[0] = temp;
            adjust(0, a.length-1-i-1);
        }
    }
}
