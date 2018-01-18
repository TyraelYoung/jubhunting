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
    private String[] words;
    private TreeNode root = new TreeNode();
    private boolean debug;

    /**
     * 构造一棵树
     *
     * @param words
     */
    public WordFilter(String[] words) {
        long start = System.currentTimeMillis();
        this.words = words;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            //查找
            // 如果找打了，则更新weight
            //没找到则插入
            TreeNode parent = root;
            for (int index = 0; index <= word.length(); index++) {
                //逐个前缀
                char current = ' ';
                if(index == 0){
                    String full = word;
                    insertSuffix(parent, full, i);
                }else{
                    int weight = i;
                    current = word.charAt(index-1);
                    TreeNode treeNode;
                    treeNode = parent.children.get(current);
                    if(treeNode == null){
                        treeNode = new TreeNode(weight);
                        parent.children.put(current, treeNode);
                    }else{
                        if(treeNode.weight < weight){
                            treeNode.weight = weight;
                        }
                    }
                    treeNode.value = current;

                    String full = word;
                    insertSuffix(treeNode, full, i);
                    parent = treeNode;

                }

            }
        }
//        printTree();
        long end = System.currentTimeMillis();
//        System.out.println("构建耗时：" + (end-start));
    }

    private void insertSuffix(TreeNode parent, String fullSuffix, int weight){
        //先插入一个空格
        char current = ' ';
        TreeNode treeNode;
        treeNode = parent.children.get(current);
        if(treeNode == null){
            treeNode = new TreeNode(weight);
            parent.children.put(current, treeNode);
        }else{
            if(treeNode.weight < weight){
                treeNode.weight = weight;
            }
        }
        treeNode.value = current;
        parent = treeNode;

        //从尾部向前逐个插入
        for(int i = fullSuffix.length() -1; i>=0; i--){
            current = fullSuffix.charAt(i);
            treeNode = parent.children.get(current);
            if(treeNode == null){
                treeNode = new TreeNode(weight);
                parent.children.put(current, treeNode);
            }else{
                if(treeNode.weight < weight){
                    treeNode.weight = weight;
                }
            }
            treeNode.value = current;
            parent = treeNode;
        }
    }

    public int f(String prefix, String suffix) {
        long start = System.currentTimeMillis();
        int result = find(prefix + " " + new StringBuilder(suffix).reverse());
        long end = System.currentTimeMillis();
//        System.out.println("查询耗时：" + (end-start));
        return result;
    }

    private int find(String key){
//        System.out.println("find:"+key);
//        System.out.println("root:"+root);
        //顺着根逐层往下找
        TreeNode parent = root;
        for(int i = 0; i<key.length();i++ ){

            char current = key.charAt(i);

//            System.out.println("下一个节点:" + current);
//            System.out.println("下一个节点:parent:" + parent);
//            print(parent, 0);

            TreeNode next = parent.children.get(current);
            if(next == null){
                return -1;
            }else{
                parent = next;
            }
//            System.out.println("下一个节点:next:" + next);

        }
//        System.out.println("结果:" );
//        print(parent, 0);
        return parent.weight;
    }

    public static class TreeNode {
        public int weight = -2;
        public char value;
        public Map<Character, TreeNode> children = new HashMap<>();

        public TreeNode() {
        }

        public TreeNode(int weight) {
            this.weight = weight;
        }
    }

    public void printTree(){

        print(root, 0);
        System.out.println();
    }

    public void print(TreeNode treeNode, int level){
//        System.out.println();
        for(int i=0; i< level; i++){
            System.out.print('-');
        }
//        System.out.print(treeNode.value);
        for(Map.Entry<Character, TreeNode> entry :treeNode.children.entrySet() ){
            print(entry.getValue(), level+1);
        }

    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
