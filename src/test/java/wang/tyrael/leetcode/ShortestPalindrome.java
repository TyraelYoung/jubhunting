package wang.tyrael.leetcode;

import org.junit.Test;
import wang.tyrael.leetcode.ShortestPalindrome214.Solution;

public class ShortestPalindrome {
    @Test
    public void test(){
        Solution solution = new Solution();

        String result;

//        "aaaaa"
        result = solution.shortestPalindrome("aaaaa");
        System.out.println("aaaaa:" +result);
        assert "aaaaa".equals(result);
    }
}
