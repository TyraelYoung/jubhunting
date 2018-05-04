package wang.tyrael.leetcode.matrix;

import org.junit.Test;
import wang.ArrayUtil;
import wang.tyrael.leetcode.matrix.risingwater778.Solution;

/**
 * @author: wangchao
 * 2018/5/2 0002
 */
public class RisingWater778 {
    @Test
    public void test(){
        Solution solution = new Solution();
        int result = solution.swimInWater(ArrayUtil.parse2D("[[0,2],[1,3]]"));
        System.out.println("result:" + result);
        assert result == 3;
    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        int result = solution.swimInWater(ArrayUtil.parse2D("[[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]"));
        System.out.println("result:" + result);
        assert result == 16;
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        int result = solution.swimInWater(ArrayUtil.parse2D("[[0]]"));
        System.out.println("result:" + result);
        assert result == 0;
    }

    @Test
    public void test3(){
        Solution solution = new Solution();
        int result = solution.swimInWater(ArrayUtil.parse2D("[]"));
        System.out.println("result:" + result);
        assert result == 0;
    }

    @Test
    public void test4(){
        Solution solution = new Solution();
        int result = solution.swimInWater(ArrayUtil.parse2D("[[]]"));
        System.out.println("result:" + result);
        assert result == 0;
    }

    @Test
    public void test5(){
        Solution solution = new Solution();
        int result = solution.swimInWater(ArrayUtil.parse2D("[[3,2],[0,1]]"));
        System.out.println("result:" + result);
        assert result == 3;
    }
}
