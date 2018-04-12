package wang.tyrael.leetcode;

import org.junit.Test;
import wang.tyrael.ArrayUtil;
import wang.tyrael.leetcode.largestnumber179.Solution;

/**
 * @author: wangchao
 */
public class LargestNumber179 {
    @Test
    public void test(){
        Solution solution = new Solution();
        String s = solution.largestNumber(ArrayUtil.parse("[3, 30, 34, 5, 9]"));
        System.out.println(s);
        assert "9534330".equals(s);
    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        String s = solution.largestNumber(ArrayUtil.parse("[0,0]"));
        System.out.println(s);
        assert "0".equals(s);
    }
}
