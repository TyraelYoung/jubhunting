package wang.tyrael.leetcode.string.palindrome.partitioningii;

import java.util.HashMap;
import java.util.Map;

public class SolutionExhaust {
    Map<String, Integer> cutCount = new HashMap<>();

    public int minCut(String s) {
        int cache = cutCount.getOrDefault(s, -1);
        if (cache > -1){
            return cache;
        }
        if (s.length() == 1 || s.isEmpty()){
            return 0;
        }
        if (isPalindrome(s)){
            cutCount.put(s, 0);
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s.length()-1; i++) {
            int left = minCut(s.substring(0, i+1 ));
            int right = minCut(s.substring(i+1));
            int thisMin = left + right+1;
            min = Math.min(min, thisMin);
        }
        cutCount.put(s, min);
        return min;
    }

    public static boolean isPalindrome(String s){
        if (s.length() == 1 || s.isEmpty()){
            return true;
        }
        for (int i = 0; i <= (s.length()-1)/2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
