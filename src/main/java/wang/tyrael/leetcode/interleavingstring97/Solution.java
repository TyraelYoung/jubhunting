package wang.tyrael.leetcode.interleavingstring97;

public class Solution {
    private byte[][] cache;

    public boolean isInterleave(String s1, String s2, String s3) {
        cache = new byte[s1.length() + 1][s2.length() + 1];
        return check(s1, s2, s3);
    }

    public boolean check(String s1, String s2, String s3) {
        if(cache[s1.length()][s2.length()] != 0){
            return cache[s1.length()][s2.length()] == 1;
        }

        if(s1.length() + s2.length() != s3.length()){
            cache[s1.length()][s2.length()] = -1;
            return false;
        }
        if(s3.length() == 0){
            return  s1.length() == 0 && s2.length() == 0;
        }
        char char3 = s3.charAt(0);
        char char1, char2;
        boolean result1 = false, result2 = false;
        if(s1.length() != 0){
            char1 = s1.charAt(0);
            if(char1 == char3){
                result1 = check(s1.substring(1), s2, s3.substring(1));
            }else{
                result1 =false;
            }
        }
        if(result1){
            cache[s1.length()][s2.length()] = 1;
            return true;
        }
        if(s2.length() != 0){
            char2 = s2.charAt(0);
            if(char2 ==char3){
                result2 = check(s1, s2.substring(1), s3.substring(1));
            }else{
                result2 = false;
            }
        }
        if(result2){
            cache[s1.length()][s2.length()] = 1;
        }else{
            cache[s1.length()][s2.length()] = -1;
        }
       return result2;
    }
}
