package wang.tyrael.leetcode.ShortestPalindrome214;

public class ShortestPalindromeTest {
    public static void main(String[] args){
        Solution solution = new Solution();

        String result;

//        "aaaaa"
        result = solution.shortestPalindrome("aaaaa");
        System.out.println("aaaaa:" +result);

        result = solution.shortestPalindrome("abb");
        System.out.println("bbabb:" +result);

        result = solution.shortestPalindrome("ba");
        System.out.println("aba:" +result);

//        Input:
//        "abbacd"
//        Output:
//        "dcabbabbacd"
//        Expected:
//        "dcabbacd"

        result = solution.shortestPalindrome("abbacd");
        System.out.println("dcabbacd:" +result);

        result = solution.shortestPalindrome("");
        System.out.println(":" +result);

        result = solution.shortestPalindrome("aacecaaa");
        System.out.println("aacecaaa:" +result);

        result = solution.shortestPalindrome("abcd");
        System.out.println("dcbabcd:" +result);
    }
}
