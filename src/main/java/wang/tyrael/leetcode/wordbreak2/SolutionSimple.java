package wang.tyrael.leetcode.wordbreak2;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain duplicate words.

 Return all such possible sentences.

 For example, given
 s = "catsanddog",
 dict = ["cat", "cats", "and", "sand", "dog"].

 A solution is ["cats and dog", "cat sand dog"].
 */
class SolutionSimple {
    public List<String> wordBreak(String s, List<String> wordDict) {
        //每次查找一个前缀，知道单词结束
        //如果单词正好结束，找到一个结果
        //单词没有结束，找不到前缀了，则没有结果
//        List<String> oneList = new ArrayList<>();
//        oneList.add("cats and dog");
//        return oneList;

        List<String> result = new ArrayList<>();
        //找到第一个词
        Stack<Node> stack = new Stack<>();
        //与stack对应的一个结果
        //一旦找到一个结果，需要输出，同时不能破坏原来stack，影响后续查找
        List<String> oneResult = new ArrayList<>();
        Node root = new Node(s, 0);
        stack.push(root);
        while(!stack.empty()){
            Node node = stack.pop();
//            System.out.println("pop:" + node);
            int index = find(node.left, wordDict, node.startIndex);
            if(index == -1){
                //该路径不存在，需要继续搜索
                //回溯，查找父节点
                //移除最后一个单词
                if(!oneResult.isEmpty()){
                    oneResult.remove(oneResult.size()-1);
                }
                continue;
            }
            //找到一个，
            String oneWord  = wordDict.get(index);
            oneResult.add(oneWord);
            if(oneWord.length() == node.left.length()){
                //字符串查找结束，找到一个结果
                //输出结果
                result.add(toSentence(oneResult));
                // 父节点入栈备用，下一次继续从这个点找
                node.startIndex = index + 1;
                stack.push(node);
                oneResult.remove(oneResult.size()-1);
            }else{
                // 父节点入栈备用，下一次继续从这个点找
                node.startIndex = index + 1;
                stack.push(node);
                //继续往后找
                //构造
                String next = node.left.substring(oneWord.length());
                Node nextNode = new Node(next, 0);
                stack.push(nextNode);
            }

        }
        return result;
    }

    private String toSentence(List<String> words){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            stringBuilder.append(words.get(i));
            stringBuilder.append(' ');
        }

        return stringBuilder.deleteCharAt(stringBuilder.length()-1).toString();
    }

    private int find(String s, List<String> wordDict, int start){
        for (int i = start; i < wordDict.size(); i++) {
            String word = wordDict.get(i);
            if(s.startsWith(word)){
                //找到
                return i;
            }
        }
        //没找到
        return -1;
    }

    public static class Node{
        public String left; // 剩余字符串长度
        public int startIndex; //下一次搜索前缀开始位置

        public Node(String left, int startIndex) {
            this.left = left;
            this.startIndex = startIndex;
        }
    }
}
