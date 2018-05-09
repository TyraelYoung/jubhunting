package wang.tyrael.leetcode.digit.removek;

/**
 * @author: wangchao
 * 2018/5/8 0008
 */
public class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() <= k){
            return "0";
        }
        //保留num.length()-k个数，每次选一位
        int left = num.length()-k;
        int thisLeft = left;
        StringBuilder result = new StringBuilder();
        for (int i = 0, start = 0 ; i < left; i++) {
            int end = num.length() - thisLeft;
            char min = Character.MAX_VALUE;
            int minIndex = -1;
            for (int j = start; j <= end; j++) {
                if (min > num.charAt(j)){
                    min = num.charAt(j);
                    minIndex = j;
                }
            }
            result.append(num.charAt(minIndex));

            start = minIndex + 1;
            thisLeft--;

            //纯优化，不影响原来逻辑
            //提前出口
            if (thisLeft == num.length() - start){
                //需要保留的个数，和待选个数一样。
                result.append(num.substring(start));
                break;
            }
        }
        int i = 0;
        for (; i < result.length(); i++) {
            if (result.charAt(i) == '0'){

            }else{
                break;
            }
        }
        result.delete(0, i);
        if (result.length() == 0){
            return "0";
        }else{
            return result.toString();
        }

    }
}
