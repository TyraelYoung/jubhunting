package wang.tyrael.leetcode.ShortestPalindrome214;

public class Solution {
    public String shortestPalindrome(String s) {
        if(s.length() == 0){
            return "";
        }
        if(s.length() == 1){
            return  s;
        }
        int midLeft ;
         midLeft = s.length() /2 -1;


        // 每一个都可能是最靠近中轴的
        // 如果匹配不成功，左移
        for(int i = midLeft; i>= 0; i--){

            if(isMidLeft(s, i, i +2)){
                return supply(s, i, i+2);
            }

            if(isMidLeft(s, i, i +1)){
                return supply(s, i, i+1);
            }

        }
        return supply(s, -1, 1);

    }

    public String supply(String s, int midLeft, int midRight){
        StringBuilder stringBuilder = new StringBuilder(s);
        int countLeft = midLeft -0;
        for(int i= midRight + countLeft +1; i< s.length(); i++){
            stringBuilder.insert(0, s.charAt(i));
        }
        return stringBuilder.toString();
    }

    public boolean isMidLeft(String s, int midLeft, int midRight){
        if(midRight >= s.length()){
            return false;
        }

        //比较左边每一个位置
        for (int i = midLeft; i >= 0 ; i--) {
            int offset = midLeft -i;
            char left = s.charAt(i);
            char right = s.charAt(midRight + offset);
            if(left == right){

            }else{
                return false;
            }
        }
        return true;
    }
}
