package wang.tyrael.lintcode.string.strstr13;

/**
 * @author: wangchao
 * 2018/7/28 0028
 */
public class Solution {
    public int strStr(String source, String target) {
        // write your code here
        KMP kmp = new KMP(target);
        return kmp.match(source);
    }
}

class KMP {
    final String pattern;
    int preIndex[];

    public KMP(String pattern) {
        this.pattern = pattern;
        computePrefix();
    }

    /**
     * 返回匹配的起始位置
     * @return 失败-1
     */
    public int match(String text){
        if (pattern == null || text == null) return -1;
        if (pattern.length() == 0) return 0;
        //模式和前缀数组的索引，
        int k = -1;
        for (int i=0; i < text.length(); i++) {
            while (k > -1 && pattern.charAt(k+1) != text.charAt(i)) k = preIndex[k];
            //准备试探下一个位置
            if (pattern.charAt(k+1) == text.charAt(i)) k++;
            //else已经没有退路了，从0开始匹配。
            //如果前面升上来了
            if (k == pattern.length()-1) return i-k;
        }
        return -1;
    }

    void computePrefix(){
        if (pattern==null || pattern.length() == 0){
            return;
        }
        preIndex = new int[pattern.length()];
        preIndex[0] = -1;
        //子串/滑动的串的指针
        int k = -1;
        //文本/父串的指针
        for (int i = 1; i < pattern.length(); i++) {
            //从开头，k = 0
            //preIndex[i] 可以在哪个基础上推进
            //注意这里试探的是k+1;试验失败，回撤;中间的必然不能匹配，直接回撤到上次记录的地方
            //一直回撤到0
            while (k > -1 && pattern.charAt(k+1) != pattern.charAt(i)) k = preIndex[k];
            //在k的基础上推进
            if (pattern.charAt(k+1) == pattern.charAt(i)) k ++;
            //else否则，只能以0为基础
            preIndex[i] = k;
        }
    }
}
