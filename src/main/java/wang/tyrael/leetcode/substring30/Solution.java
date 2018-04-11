package wang.tyrael.leetcode.substring30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if(s.isEmpty() ||words.length == 0){
            return result;
        }
        //处理重复
        Map<String, Integer> map = new HashMap<>();
        for (String word :
                words) {
            Integer integer = map.get(word);
            if (integer == null){
                map.put(word, 1);
            }else{
                map.put(word, integer +1);
            }
        }

        //尝试匹配
        //每个字符都可能匹配上
        int wordLength = words[0].length();
        for (int i = 0; i <= s.length() - words.length * wordLength; i++) {
            Map<String, Integer> matchResult = new HashMap<>();
            //以i开始，尝试找字符串
            int j;
            for (j = i; j < i + words.length * wordLength; j += wordLength) {
                String segment = s.substring(j, j+wordLength);
                Integer integer = map.get(segment);
                if (integer == null) {
                    break;
                } else {
                    int matchTimes = matchResult.getOrDefault(segment, 0);
                    matchTimes++;
                    if (matchTimes > integer) {
                        break;
                    }
                    matchResult.put(segment, matchTimes);
                }
            }
            if(j - i == words.length * wordLength){
                result.add(i);
            }
        }
        return result;
    }
}
