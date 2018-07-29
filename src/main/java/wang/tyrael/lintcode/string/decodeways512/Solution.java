package wang.tyrael.lintcode.string.decodeways512;

/**
 * @author: wangchao
 * 2018/7/28 0028
 */
public class Solution {
    public int numDecodings(String s) {
        // write your code here
        if (s==null || s.isEmpty()){
            return 0;
        }
        if (s.length()==1){
            return one(s);
        }
        int pre2 = 1, pre1 = one(s.substring(0, 1));
        int current = 0;
        for (int i = 1; i < s.length(); i++) {
            current = pre2 * two(s.substring(i-1, i+1)) + pre1 * one(s.substring(i, i+1));

            pre2 = pre1;
            pre1 = current;
        }
        return current;
    }

    public int one(String one) {
        char c = one.charAt(0);
        switch (c) {
            case '0':
                return 0;
            default:
                return 1;
        }
    }

    public int two(String two) {
        char right1 = two.charAt(0);
        char right0 = two.charAt(1);
        switch (right1) {
            case '1':
                return 1;
            case '2':
                return right0 < '7' ? 1 : 0;
            default:
                return 0;
        }
    }
}
