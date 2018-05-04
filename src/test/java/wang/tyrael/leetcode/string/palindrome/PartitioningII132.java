package wang.tyrael.leetcode.string.palindrome;

import org.junit.Test;
import wang.tyrael.leetcode.string.palindrome.partitioningii.Solution;

public class PartitioningII132 {
    @Test
    public void test(){
        Solution solution = new Solution();
        int result  = solution.minCut("aab");
        System.out.println("result:" + result);
        assert result == 1;
    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        int result  = solution.minCut("aaaabbbb");
        System.out.println("result:" + result);
        assert result == 1;
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        int result  = solution.minCut("abc");
        System.out.println("result:" + result);
        assert result == 2;
    }

    @Test
    public void test3(){
        Solution solution = new Solution();
        int result  = solution.minCut("a");
        System.out.println("result:" + result);
        assert result == 0;
    }

    @Test
    public void test4(){
        Solution solution = new Solution();
        int result  = solution.minCut("apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp");
        System.out.println("result:" + result);
//        assert result == 4;
    }
    @Test
    public void test5(){
        Solution solution = new Solution();
        int result  = solution.minCut("coder");
        System.out.println("result:" + result);
        assert result == 4;
    }
}
