package wang.tyrael.leetcode.string.strongpassword420;

import java.util.Arrays;

/**
 * @author: wangchao
 * 2018/6/12 0012
 */
public class Solution {
    public int strongPasswordChecker(String s) {

    }

    int convert2Less(String s) {
        return 6 - s.length();
    }

    int convert2To6(String s) {
        //+
        int sizeToAdd = 6 - s.length();
        //+
        int absenceToChange = absence(s);
        //+
        int sameToChange = same(s);
        //三者可以合并解决
        return Arrays.stream(new int[]{sizeToAdd, absenceToChange, sameToChange}).max().getAsInt();
    }

    int convert6To20(String s){
        //replace解决
        int absenceToChange = absence(s);
        //replace解决
        int sameToChange = same(s);
        //合并解决
        return Math.max(sameToChange, absenceToChange);
    }

    int convert20more(String s){
        //尝试合并解决size和same的问题，为了不影响缺席问题，只去除相同的字母。
        StringBuilder stringBuilder = new StringBuilder(s);
        int countSame = 0;
        int countChange = 0;
        for (int i = stringBuilder.length()-1; i >=0 ; i++) {
            char thisChar = data.charAt(i);
            if (lastChar == thisChar){
                countSame++;
            }else{
                countSame = 1;
            }
            if(countSame % 3 == 0){
                countChange++;
            }
        }
    }



    int same(String data){
        int lastChar = -1;
        int countSame = 0;
        int countChange = 0;
        for (int i = 0; i < data.length(); i++) {
            char thisChar = data.charAt(i);
            if (lastChar == thisChar){
                countSame++;
            }else{
                countSame = 1;
            }
            if(countSame % 3 == 0){
                countChange++;
            }
        }
        return countChange;
    }

    int absence(String s) {
        int countDigit = 0;
        int countUpper = 0;
        int countLower = 0;
        for (int i = 0; i < s.length(); i++) {
            char in = s.charAt(i);
            if (in <= '9' && in >= '0') {
                countDigit++;
            }
            if (in <= 'Z' && in >= 'A') {
                countUpper++;
            }
            if (in < 'z' && in >= 'a') {
                countLower++;
            }
        }
        int absence = 0;
        if (countDigit == 0) absence++;
        if (countLower == 0) absence++;
        if (countUpper == 0) absence++;
        return absence;
    }

}
