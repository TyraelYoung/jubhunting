package wang.tyrael.leetcode.atoi8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if(str.isEmpty()){
            return 0;
        }
        int sign = 1;
        if(str.startsWith("-")){
            sign = -1;
            str = str.substring(1);
        }else if(str.startsWith("+")){
            str = str.substring(1);
        }
        String pattern = "^\\d+";
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(str);
        if(matcher.find()){
            String s = matcher.group();
            return parse(s, sign);
        }else{
            return 0;
        }
    }

    public int parse(String s, int sign){
        int sum = 0;
        int radix = 10;
        if(sign > 0){
            for (int i = 0; i < s.length(); i++) {
                int num = s.charAt(s.length() -1-i) - '0';
                sum += Math.pow(radix, i) * num;
                if(sum < 0){
                    return Integer.MAX_VALUE;
                }
            }
            return sum;
        }else{
            for (int i = 0; i < s.length(); i++) {
                int num = s.charAt(s.length() -i-1) - '0';
                sum -= Math.pow(radix, i) * num;
                if(sum > 0){
                    return Integer.MIN_VALUE;
                }
            }
            return sum;
        }
    }

}

//    1 The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
//
// 2 Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
//
//    3    The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
//
//      4  If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
//
//        If no valid conversion could be performed, a zero value is returned.
//
// 5 If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
