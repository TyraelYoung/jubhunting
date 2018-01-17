package wang.tyrael.leetcode;


import java.util.HashMap;
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
class WordFilter2 {
    private String[] words;
    private TreeNode root = new TreeNode();

    /**
     * 构造一棵树
     *
     * @param words
     */
    public WordFilter2(String[] words) {
        this.words = words;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            //查找
            // 如果找打了，则更新weight
            //没找到则插入
            for (int prefixL = 0; prefixL <= word.length(); prefixL++) {
                //逐个前缀
                int suffixL = word.length();
                //逐个后缀
                String prefix;

                if (prefixL == 0) {
                    prefix = "";
                } else {
                    prefix = word.substring(0, prefixL);
                }

                String suffix;
                suffix = word.substring(word.length() - suffixL, word.length());

                //构建一个分支
                TreeNode parent = root;
                int max = Math.max(prefixL, suffixL);
                for (int m = 0; m <= max; m++) {
                    Map<String, TreeNode> children = parent.children;
                    String preChar;
                    String sufChar;
                    if (m <= prefixL && m>0) {
                        preChar = "" + prefix.charAt(m - 1);
                    } else {
                        preChar = "";
                    }
                    if (m <= suffixL && m>0) {
                        sufChar = "" + suffix.charAt(suffixL - m);
                    } else {
                        sufChar = "";
                    }

                    String key = preChar + " " + sufChar;
                    TreeNode treeNode = children.get(key);
                    if (treeNode == null) {
                        treeNode = new TreeNode();
                        treeNode.weight = i;
                        children.put(key, treeNode);
                    } else {
                        if (treeNode.weight < i) {
                            treeNode.weight = i;
                        }
                    }
                    parent = treeNode;
                }

            }
        }
    }

    public int f(String prefix, String suffix) {
        TreeNode parent = root;
        //查找
        // 如果找打了，则更新weight
        //没找到则插入
        int prefixL = prefix.length();
        int suffixL = suffix.length();

        int max = Math.max(prefixL, suffixL);
        if (max == 0) {
            return words.length - 1;
        }
        TreeNode lastPair = null;
        for (int m = 0; m <= max; m++) {
            Map<String, TreeNode> children = parent.children;
            String preChar;
            String sufChar;
            if (m <= prefixL && m>0) {
                preChar = "" + prefix.charAt(m - 1);
            } else {
                preChar = "";
            }
            if (m <= suffixL && m>0) {
                sufChar = "" + suffix.charAt(suffixL - m);
            } else {
                sufChar = "";
            }

            String key = prefix + " " + suffix;
            TreeNode treeNode = children.get(key);
            if (treeNode == null) {
                return -1;
            }
            //找到当前字母，找下一个字母
            parent = treeNode;
            lastPair = treeNode;
        }
        return lastPair.weight;
    }

    public static class TreeNode {
        public int weight;
        public Map<String, TreeNode> children = new HashMap<>();
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
