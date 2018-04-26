package wang.tyrael.leetcode;

import org.junit.Test;
import wang.tyrael.leetcode.reversebits190.Solution;

public class ReverseBits190 {
    @Test
    public void test(){
        Solution solution = new Solution();
        int result = solution.reverseBits(43261596 );
        System.out.println("result:" + result);
        assert 964176192 == result;
    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        int result = solution.reverseBits(1 );
        System.out.println("result:" + result);
//        assert 964176192 == result;
    }
}
