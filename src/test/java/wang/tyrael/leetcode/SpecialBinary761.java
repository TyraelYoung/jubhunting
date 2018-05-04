package wang.tyrael.leetcode;

import org.junit.Test;
import wang.tyrael.leetcode.specialbinary761.Solution;

public class SpecialBinary761{
    @Test
    public void test1(){
        Solution solution = new Solution();
        String result = solution.makeLargestSpecial("10");
        System.out.println("result:" + result);
        assert result.equals("10");
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        String result = solution.makeLargestSpecial("11011000");
        System.out.println("result:" + result);
        assert result.equals("11100100");
    }
}
