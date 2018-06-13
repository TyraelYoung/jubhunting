package wang.tyrael.leetcode;

import org.junit.Test;
import wang.tyrael.ArrayUtil;
import wang.tyrael.leetcode.wordsearch2.Solution;

import java.util.List;

/**
 * @author: wangchao
 */
public class WordSearch2 {
//    [["a","a"]]
//            ["a"]
    @Test
    public void test2(){
        Solution solution = new Solution();
        List<String> result = solution.findWords(
                ArrayUtil.parseChar2D("[[\"a\",\"a\"]]"),
                ArrayUtil.parseString("[\"a\"]"));
        System.out.println("test:" + result.size());
        ArrayUtil.print(result);
    }
//    [["b"],["a"],["b"],["b"],["a"]]
//            ["baa","abba","baab","aba"]
    @Test
    public void test1(){
        Solution solution = new Solution();
        List<String> result = solution.findWords(
                ArrayUtil.parseChar2D("[[\"b\"],[\"a\"],[\"b\"],[\"b\"],[\"a\"]]"),
                ArrayUtil.parseString("[\"baa\",\"abba\",\"baab\",\"aba\"]"));
        System.out.println("test:" + result.size());
        ArrayUtil.print(result);
    }


    @Test
    public void test(){
        Solution solution = new Solution();
        List<String> result = solution.findWords(
                ArrayUtil.parseChar2D("[\n" +
                        "  ['o','a','a','n'],\n" +
                        "  ['e','t','a','e'],\n" +
                        "  ['i','h','k','r'],\n" +
                        "  ['i','f','l','v']\n" +
                        "]"),
                ArrayUtil.parseString("[\"oath\",\"pea\",\"eat\",\"rain\"]"));
        System.out.println("test:" + result.size());
        ArrayUtil.print(result);
    }
}
