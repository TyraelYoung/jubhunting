package wang.tyrael.leetcode.removeduplicate316;

/**
 * @author: wangchao
 * 2018/4/26 0026
 */
public class Solution {
    public String removeDuplicateLetters(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        //逐个删除
        for (char i = 'z'; i >= 'a'; i--) {
            boolean found = false;
            for (int j = stringBuilder.length()-1; j >= 0 ; j--) {
                if (stringBuilder.charAt(j) == i){
                    if (found){
                        stringBuilder.deleteCharAt(j);
                    }else{
                        found = true;
                    }
                }
            }
        }
        return stringBuilder.toString();
    }
}
