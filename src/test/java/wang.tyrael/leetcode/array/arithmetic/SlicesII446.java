package wang.tyrael.leetcode.array.arithmetic;

import org.junit.Test;
import wang.tyrael.ArrayUtil;
import wang.tyrael.leetcode.array.arithmetic.slicesii.Solution;

public class SlicesII446 {
    @Test
    public void test(){
        Solution solution = new Solution();
        int reuslt = solution.numberOfArithmeticSlices(ArrayUtil.parse("[2, 4, 6, 8, 10]"));
        System.out.println("result:" + reuslt);
        assert reuslt == 7;
    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        int reuslt = solution.numberOfArithmeticSlices(ArrayUtil.parse("[]"));
        System.out.println("result:" + reuslt);
        assert reuslt == 0;
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        int reuslt = solution.numberOfArithmeticSlices(ArrayUtil.parse("[1]"));
        System.out.println("result:" + reuslt);
        assert reuslt == 0;
    }

    @Test
    public void test3(){
        Solution solution = new Solution();
        int reuslt = solution.numberOfArithmeticSlices(ArrayUtil.parse("[1,2]"));
        System.out.println("result:" + reuslt);
        assert reuslt == 0;
    }

    @Test
    public void test4(){
        Solution solution = new Solution();
        int reuslt = solution.numberOfArithmeticSlices(ArrayUtil.parse("[1,2,3]"));
        System.out.println("result:" + reuslt);
        assert reuslt == 1;
    }

    @Test
    public void test5(){
        Solution solution = new Solution();
        int reuslt = solution.numberOfArithmeticSlices(ArrayUtil.parse("[2,2,3,4]"));
        System.out.println("result:" + reuslt);
        assert reuslt == 2;
    }
}
