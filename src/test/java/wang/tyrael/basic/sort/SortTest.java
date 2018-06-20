package wang.tyrael.basic.sort;

import org.junit.Test;
import wang.tyrael.ArrayUtil;
import wang.tyrael.basic.sort.HeapSort;

import java.util.Arrays;

public class SortTest {
    @Test
    public void test(){
        int[] a = ArrayUtil.parse("[2,3,4,1]");
        int[] copy = Arrays.copyOf(a, a.length);
        new QuickSort(copy).sort();
        System.out.println("QuickSort:");
        ArrayUtil.printArray(copy);
        System.out.println();

        copy = Arrays.copyOf(a, a.length);
        new HeapSort(copy).sort();
        System.out.println("HeapSort:");
        ArrayUtil.printArray(copy);
        System.out.println();

        copy = Arrays.copyOf(a, a.length);
        new MergeSort(copy).sort();
        System.out.println("MergeSort:");
        ArrayUtil.printArray(copy);
        System.out.println();
    }

    @Test
    public void test1(){
        int[] a = ArrayUtil.parse("[4,1]");
        int[] copy = Arrays.copyOf(a, a.length);
        new QuickSort(copy).sort();
        System.out.println("QuickSort:");
        ArrayUtil.printArray(copy);
        System.out.println();

        copy = Arrays.copyOf(a, a.length);
        new HeapSort(copy).sort();
        System.out.println("HeapSort:");
        ArrayUtil.printArray(copy);
        System.out.println();

        copy = Arrays.copyOf(a, a.length);
        new MergeSort(copy).sort();
        System.out.println("MergeSort:");
        ArrayUtil.printArray(copy);
        System.out.println();
    }
}
