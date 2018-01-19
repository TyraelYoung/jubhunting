package wang.tyrael.leetcode.wordbreak2;

import java.util.*;

/**
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain duplicate words.

 Return all such possible sentences.

 For example, given
 s = "catsanddog",
 dict = ["cat", "cats", "and", "sand", "dog"].

 A solution is ["cats and dog", "cat sand dog"].
 */
class Solution {
    private Map<Integer, List<String>> cache;

    public List<String> wordBreak(String s, List<String> wordDict) {
        cache = new HashMap<>();
        return  wordBreak(s, wordDict, 0);
    }

    /**
     *
     * @param s 当前查找字符串
     * @param wordDict
     * @param start  当前查找字符串的相对原字符串的起始位置，用于cache
     * @return
     */
    public List<String> wordBreak(String s, List<String> wordDict, int start) {
        //每次查找一个前缀，知道单词结束
        //如果单词正好结束，找到一个结果
        //单词没有结束，找不到前缀了，则没有结果
        if(cache.containsKey(start)){
//            System.out.println("cache.containsKey(start):" + start);
            return cache.get(start);
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < wordDict.size(); i++) {
            //每个词都可能是前缀
            String oneWord = wordDict.get(i);
            if(s.startsWith(oneWord)){
                if(s.equals(oneWord)){
                    result.add(oneWord);
                    continue;
                }else{
                    //可以作为前缀
                    List<String> small = wordBreak(s.substring(oneWord.length()), wordDict, start + oneWord.length());
                    for (int j = 0; j < small.size(); j++) {
                        result.add(oneWord + " " + small.get(j));
                    }
                }
            }else{
                //不能作为前缀
                //前缀都找不到，不能匹配了
            }
        }
        cache.put(start, result);
        return  result;
    }
}
