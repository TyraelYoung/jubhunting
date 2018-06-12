package wang.tyrael.leetcode.string.strongpassword420;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: wangchao
 * 2018/6/12 0012
 */
public class Solution {
    public class Window{
        int size = 0;
        /**
         * 连续相等
         */
        int countSame = 0;

        int countDigit;
        int countUpper;
        int countLower;

        /**
         * 需要多少改变
         */
        int countChange;

        List<Character> data = new LinkedList<>();

        public void move(char in){
            if (size < 20){
                if (in == data.get(data.size()-1)){
                    countSame++;
                    if (countSame >= 3){
                        countChange ++;
                        countSame --;
                    }
                }else{
                    countSame = 1;
                }
                if (in <= '9' && in >= '0'){
                    countDigit++;
                }
                if (in <= 'Z' && in >= 'A'){
                    countUpper ++;
                }
                if (in < 'z' && in >= 'a'){
                    countLower ++;
                }
            }else{

            }
        }

        public int countChange(){

        }
    }

    public int strongPasswordChecker(String s) {
        Window window = new Window();
        int min = 0;
        for (int i = 0; i < s.length(); i++) {
            window.move(s.charAt(i));
            if (window.countChange < min){
                min = window.countChange;
            }
        }
        return min;
    }
}
