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

    @Test
    public void test3(){
        Solution solution = new Solution();
        int[] result = solution.maxNumber(
                ArrayUtil.parse("[8,6,9]"),
                ArrayUtil.parse("[1, 7, 5]"),
                3
        );
        System.out.println("[9,7,5]:");
        ArrayUtil.printArray(result);
        System.out.println();
    }

    @Test
    public void test4(){
        Solution solution = new Solution();
        int[] result = solution.maxNumber(
                ArrayUtil.parse("[8, 9]"),
                ArrayUtil.parse("[3, 9]"),
                3
        );
        System.out.println("[9, 8, 9]:");
        ArrayUtil.printArray(result);
        System.out.println();
    }

//    Input:
//            [2,5,6,4,4,0]
//            [7,3,8,0,6,5,7,6,2]
//            15
//    Output:
//            [7,3,8,2,5,6,4,4,0,0,6,5,7,6,2]
//    Expected:
//            [7,3,8,2,5,6,4,4,0,6,5,7,6,2,0]
}
