package wang.tyrael.basic.string;

/**
 * 脑中有个后缀前缀关系图。已匹配截断的后缀，pattern的前缀。
 * 最长前缀就是当前回撤的位置。
 */
public class KMP {
    final String text, pattern;
    int pi[];

    public KMP(String text, String pattern) {
        this.text = text;
        this.pattern = pattern;
        pi = new int[pattern.length()];
    }

    /**
     * 返回匹配的起始位置
     * @return 失败-1
     */
    public int match(){
        computePrefix();
        //模式和前缀数组的索引，
        int k = -1, i = 0;
        for (; i < text.length(); i++) {
            while (k > -1 && pattern.charAt(k+1) != text.charAt(i)) k = pi[k];
            //准备试探下一个位置
            if (pattern.charAt(k+1) == text.charAt(i)) k++;
            //else已经没有退路了，从0开始匹配。
            //如果前面升上来了
            if (k == pattern.length()-1) return i-k;
        }
        return -1;
    }

    void computePrefix(){
        pi[0] = -1;
        //子串/滑动的串的指针
        int k = -1;
        //文本/父串的指针
        for (int i = 1; i < pattern.length(); i++) {
            //从开头，k = 0
            //pi[i] 可以在哪个基础上推进
            //注意这里试探的是k+1;试验失败，回撤;中间的必然不能匹配，直接回撤到上次记录的地方
            //一直回撤到0
            while (k > -1 && pattern.charAt(k+1) != pattern.charAt(i)) k = pi[k];
            //在k的基础上推进
            if (pattern.charAt(k+1) == pattern.charAt(i)) k ++;
            //else否则，只能以0为基础
            pi[i] = k;
        }
    }
}
