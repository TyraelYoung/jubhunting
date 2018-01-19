package wang.tyrael.leetcode.wordbreak2;

import com.alibaba.fastjson.JSON;

import java.util.List;

public class WordBreak2Test {
    public static void main(String[] args){
        SolutionSimple solutionSimple = new SolutionSimple();
        Solution solution = new Solution();
        //["cat", "cats", "and", "sand", "dog"]
        List<String> list = JSON.parseArray("[\"cat\", \"cats\", \"and\", \"sand\", \"dog\"]", String.class);
        List<String> result = solution.wordBreak("catsanddog", list);
        System.out.println(JSON.toJSONString(result));


//        "aaaaaaa"
//                ["aaaa","aa","a"]
        list = JSON.parseArray("[\"aaaa\",\"aa\",\"a\"]", String.class);
        result = solution.wordBreak("aaaaaaa", list);

        System.out.println("size:" + result.size());
        System.out.println(JSON.toJSONString(result));


//        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
//                ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]

        list = JSON.parseArray("[\"a\",\"aa\"]", String.class);
        result = solution.wordBreak("aaaaaaaaaaaaaaaaaaaaa", list);

        System.out.println("size:" + result.size());
        System.out.println(JSON.toJSONString(result));

//        list = JSON.parseArray("[\"a\",\"aa\",\"aaa\",\"aaaa\"]", String.class);
//        result = solution.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", list);
//        System.out.println(JSON.toJSONString(result));
//
//        list = JSON.parseArray("[\"a\",\"aa\",\"aaa\",\"aaaa\",\"aaaaa\",\"aaaaaa\",\"aaaaaaa\",\"aaaaaaaa\",\"aaaaaaaaa\",\"aaaaaaaaaa\"]", String.class);
//        result = solution.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", list);
//        System.out.println(JSON.toJSONString(result));

    }
}
