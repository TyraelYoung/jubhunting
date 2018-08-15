package wang.tyrael.leetcode.string.palindrome;

import org.junit.Test;
import wang.tyrael.leetcode.TestStatic;
import wang.tyrael.leetcode.string.palindrome.longestsubstring5.Solution;

public class LongestSubstring5 {
    @Test
    public void test(){
        Solution solution = new Solution();
        String result = solution.longestPalindrome("babad");
        TestStatic.assertAndPrint("bab", result);
    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        String result = solution.longestPalindrome("cbbd");
        TestStatic.assertAndPrint("bb", result);
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        String result = solution.longestPalindrome("");
        TestStatic.assertAndPrint("", result);
    }

    @Test
    public void test3(){
        Solution solution = new Solution();
        String result = solution.longestPalindrome("1");
        TestStatic.assertAndPrint("1", result);
    }
}
