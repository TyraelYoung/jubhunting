package wang.tyrael.leetcode.regularexpressionmatching10;

public class RegularExpressionMatchingTest {
    public static void main(String[] args){
        Solution solution = new Solution();
        boolean result =solution.isMatch("aa","a") ; System.out.println(" false:" + result);
         result =solution.isMatch("aa","aa") ; System.out.println(" true:" + result);
         result =solution.isMatch("aaa","aa") ; System.out.println(" false:" + result);
         result =solution.isMatch("aa", "a*") ; System.out.println(" true:" + result);
         result =solution.isMatch("aa", ".*") ; System.out.println(" true:" + result);
         result =solution.isMatch("ab", ".*") ; System.out.println(" true:" + result);
         result =solution.isMatch("aab", "c*a*b") ; System.out.println(" true:" + result);
    }
}
