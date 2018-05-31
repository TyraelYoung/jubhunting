package wang.tyrael.leetcode.string.reversewords151;

/**
 * @author: wangchao
 * 2018/5/31 0031
 */
public class Solution {
    public String reverseWords(String s) {
        if (s == null){
            return null;
        }
        if (s.length() == 0){
            return "";
        }
        char[] letters = s.toCharArray();
        reverse(0, letters.length-1, letters);
        int start = -1, end =-1;
        while(end < letters.length-1){
            start = end+1;
            while (start < letters.length && letters[start] == ' '){
                start ++;
            }
            end = start;
            while (end+1 < letters.length && letters[end+1] != ' '){
                end ++;
            }
            if (end < letters.length){
                reverse(start, end, letters);
            }
        }
        //去除多余的0
        boolean flagHasSpace = true;
        int endIndex = 0;
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == ' '){
                if (flagHasSpace){
                    continue;
                }else{
                    letters[endIndex] = letters[i];
                    endIndex++;
                    flagHasSpace = true;
                }
            }else {
                flagHasSpace = false;
                letters[endIndex] = letters[i];
                endIndex++;
            }
        }
        //去除最后一个空格
        if (endIndex >0 && endIndex-1 < letters.length && letters[endIndex-1] == ' '){
            endIndex--;
        }
        return new String(letters, 0, endIndex);
    }

    /**
     *
     * @param start
     * @param end include
     * @return
     */
    private void reverse(int start, int end, char[] letters){
        for (int i = 0; i < (end -start) /2; i++) {
            char tmp = letters[start + i];
            letters[start + i] = letters[end-i];
            letters[end-i] = tmp;
        }
    }
}
