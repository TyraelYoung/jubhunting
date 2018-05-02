package wang.tyrael.leetcode.kth;

import org.junit.Test;
import wang.tyrael.ArrayUtil;
import wang.tyrael.leetcode.kth.primefraction786.Solution;

/**
 * @author: wangchao
 * 2018/4/28 0028
 */
public class PrimeFraction786 {
    @Test
    public void test(){
        Solution solution = new Solution();
        int[] result = solution.kthSmallestPrimeFraction(ArrayUtil.parse("[1, 2, 3, 5]"), 3);
        ArrayUtil.printArray(result);
        System.out.println();
        assert result[0] == 2;
        assert result[1] == 5;
    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        int[] result = solution.kthSmallestPrimeFraction(ArrayUtil.parse("[1, 7]"), 1);
        ArrayUtil.printArray(result);
        System.out.println();
        assert result[0] == 1;
        assert result[1] == 7;
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        int[] result = solution.kthSmallestPrimeFraction(ArrayUtil.parse("[1,13,17,59]"), 6);
        ArrayUtil.printArray(result);
        System.out.println();
        assert result[0] == 13;
        assert result[1] == 17;
    }

    @Test
    public void test3(){
        Solution solution = new Solution();
        int[] result = solution.kthSmallestPrimeFraction(ArrayUtil.parse("[1,7,23,29,47]"), 8);
        ArrayUtil.printArray(result);
        System.out.println();
        assert result[0] == 23;
        assert result[1] == 47;
    }
}
