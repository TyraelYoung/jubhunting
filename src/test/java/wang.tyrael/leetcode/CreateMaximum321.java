package wang.tyrael.leetcode;

import org.junit.Test;
import wang.tyrael.ArrayUtil;
import wang.tyrael.leetcode.createmaximum321.Solution;

public class CreateMaximum321 {
    @Test
    public void test(){
        Solution solution = new Solution();
        int[] result = solution.maxNumber(
                ArrayUtil.parse("[3, 4, 6, 5]"),
                ArrayUtil.parse("[9, 1, 2, 5, 8, 3]"),
                5
        );
        System.out.println("[9, 8, 6, 5, 3]:");
        ArrayUtil.printArray(result);
        System.out.println();
    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        int[] result = solution.maxNumber(
                ArrayUtil.parse("[6, 7]"),
                ArrayUtil.parse("[6, 0, 4]"),
                5
        );
        System.out.println("[6, 7, 6, 0, 4]:");
        ArrayUtil.printArray(result);
        System.out.println();
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        int[] result = solution.maxNumber(
                ArrayUtil.parse("[3, 9]"),
                ArrayUtil.parse("[8, 9]"),
                3
        );
        System.out.println("[9, 8, 9]:");
        ArrayUtil.printArray(result);
        System.out.println();
    }
}
