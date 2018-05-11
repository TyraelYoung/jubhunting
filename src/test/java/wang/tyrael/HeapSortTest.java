package wang.tyrael;

import org.junit.Test;
import wang.ArrayUtil;
import wang.HeapSort;

public class HeapSortTest {
    @Test
    public void test(){
        int[] a = ArrayUtil.parse("[2,3,4,1]");
        HeapSort.sort(a);
        ArrayUtil.printArray(a);
    }
}
