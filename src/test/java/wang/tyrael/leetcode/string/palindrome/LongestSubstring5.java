package wang.tyrael.leetcode.string.palindrome;

import org.junit.Test;
import wang.tyrael.leetcode.TestStatic;
import wang.tyrael.leetcode.string.palindrome.longestsubstring5.Solution;

public class LongestSubstring5 {
    @Test
    public void test(){
        Solution solution = new Solution();
        String result = solution.longestPalindrome("babad");
        TestStatic.assertResult("bab", result);
    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        String result = solution.longestPalindrome("cbbd");
        TestStatic.assertResult("bb", result);
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        String result = solution.longestPalindrome("");
        TestStatic.assertResult("", result);
    }

    @Test
    public void test3(){
        Solution solution = new Solution();
        String result = solution.longestPalindrome("1");
        TestStatic.assertResult("1", result);
    }
}
