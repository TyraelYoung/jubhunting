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
                size++;
            }else{
                char out = data.remove(0);
                if (out <= '9' && out >= '0'){
                    countDigit--;
                }
                if (out <= 'Z' && out >= 'A'){
                    countUpper --;
                }
                if (out < 'z' && out >= 'a'){
                    countLower --;
                }
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
            data.add(in);
        }

        public int countChange(){
            int absenseToChange = processAbsense();
            int sameToChange = processSame();
            if (size < 2){
                return 6-size;
            }else if(size <6){
                int sizeToChange = 6-size;
                //上面两个没有重叠关系
                //这个跟上面有重叠关系
                if (sameToChange + sizeToChange > absenseToChange){
                    return sameToChange + sizeToChange;
                }else{
                    return absenseToChange;
                }
            }else{
                if (sameToChange  > absenseToChange){
                    return sameToChange ;
                }else{
                    return absenseToChange;
                }
            }
        }

        private int processAbsense(){
            int absenseToChange = 0;
            if (countDigit ==0){
                absenseToChange ++;
            }
            if (countUpper == 0){
                absenseToChange++;
            }
            if (countLower == 0){
                absenseToChange++;
            }
            return absenseToChange;
        }

        private int processSame(){
            int lastChar = -1;
            int countSame = 0;
            int countChange = 0;
            for (int i = 0; i < data.size(); i++) {
                char thisChar = data.get(i);
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
        if (s.length() > 20){
            return min + s.length() -20;
        }else{
            return window.countChange;
        }
    }
}
