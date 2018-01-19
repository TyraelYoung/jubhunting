package wang.tyrael.leetcode.regularexpressionmatching10;

public class RegularExpressionMatchingTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result;

//        "abbabaaaaaaacaa"
//        "a*.*b.a.*c*b*a*c*"
        result = solution.isMatch("abbabaaaaaaacaa", "a*.*b.a.*c*b*a*c*");
        System.out.println(" true:" + result);
//        ""
//        ".ac*"
//        result = solution.isMatch("", ".ac*");
//        System.out.println(" false:" + result);
//
////        ""
////        "c*c*"
//        result = solution.isMatch("", "c*c*");
//        System.out.println(" true:" + result);
//
//        result = solution.isMatch("aa", "a");
//        System.out.println(" false:" + result);
//        result = solution.isMatch("aa", "aa");
//        System.out.println(" true:" + result);
//        result = solution.isMatch("aaa", "aa");
//        System.out.println(" false:" + result);
//        result = solution.isMatch("aa", "a*");
//        System.out.println(" true:" + result);
//        result = solution.isMatch("aa", ".*");
//        System.out.println(" true:" + result);
//        result = solution.isMatch("ab", ".*");
//        System.out.println(" true:" + result);
//        result = solution.isMatch("aab", "c*a*b");
//        System.out.println(" true:" + result);
//
////        "a"
////        ".*..a*"
//        result = solution.isMatch("a", ".*..a*");
//        System.out.println(" false:" + result);
////        "a"
////        ""
//        result = solution.isMatch("a", "");
//        System.out.println(" false:" + result);
//
////        ""
////        "bab"
//        result = solution.isMatch("", "bab");
//        System.out.println(" false:" + result);
//
////        "ab"
////        ".*..c*"
//
//        result = solution.isMatch("ab", ".*..c*");
//        System.out.println(" true:" + result);
    }
}
