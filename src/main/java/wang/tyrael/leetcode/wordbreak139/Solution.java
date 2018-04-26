package wang.tyrael.leetcode.wordbreak139;

import java.util.List;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0){
            return false;
        }
        if (wordDict.size() == 0){
            return false;
        }
        //on
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (String item :
                wordDict) {
            if (item.length() < min){
                min = item.length();
            }
            if (item.length() > max){
                max = item.length();
            }
        }
        //Ai 依赖 Ai-max -Ai-min
        boolean[] flagFound = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            //长度比较
            int indexMin = i -max;
            int indexMax = i -min;
            for (int j = indexMin; j <= indexMax; j++) {
                if (j >= 0 && !flagFound[j]){
                    continue;
                }
                // j 为-1时，表示从0开始匹配
                if (j < -1){
                    continue;
                }
                String tail = s.substring(j +1);
                for (String item:
                        wordDict) {
                    if (tail.startsWith(item)){
                        if (j + item.length() < s.length()){
                            flagFound[j + item.length()] = true;
                        }
                    }
                }

            }

        }
        return flagFound[s.length()-1];
    }
}
