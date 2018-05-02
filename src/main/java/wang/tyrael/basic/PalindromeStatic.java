package wang.tyrael.basic;

public class PalindromeStatic {
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
