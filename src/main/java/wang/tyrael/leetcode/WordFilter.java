package wang.tyrael.leetcode;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Given many words, words[i] has weight i.
//
//        Design a class WordFilter that supports one function, WordFilter.f(String prefix, String suffix). It will return the word with given prefix and suffix with maximum weight. If no word exists, return -1.
//
//        Examples:
//        Input:
//        WordFilter(["apple"])
//        WordFilter.f("a", "e") // returns 0
//        WordFilter.f("b", "") // returns -1
//        Note:
//        words has length in range [1, 15000].
//        For each test case, up to words.length queries WordFilter.f may be made.
//        words[i] has length in range [1, 10].
//        prefix, suffix have lengths in range [0, 10].
//        words[i] and prefix, suffix queries consist of lowercase letters only.
class WordFilter {
    public static void main(String[] args) {
        WordFilter obj = new WordFilter(new String[]{"apple"});
        int param_1 = obj.f("a", "e");
        System.out.println("0:" + param_1);
        param_1 = obj.f("b", "");
        System.out.println("-1:" + param_1);
    }

    private String[] words;
    private TreeNode root = new TreeNode();

    /**
     *  构造一棵树
     * @param words
     */
    public WordFilter(String[] words) {
        this.words = words;
        for(int i=0; i< words.length; i++){
            String word = words[i];
            TreeNode parent = root;
            //查找
            // 如果找打了，则更新weight
            //没找到则插入
            for()

        }
    }

    public int f(String prefix, String suffix) {
        for(int i= words.length-1; i>=0; i--){
            String word = words[i];
            if(word.startsWith(prefix) && word.endsWith(suffix)){
                return i;
            }
        }
        return -1;
    }

    public static class TreeNode{
        public int weight;
        public Map<Character, TreeNode> children = new HashMap<>();
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
