package wang.tyrael.basic.trie;

/**
 * @author: wangchao
 */
public class Node {
    Node[] children;
    //叶子节点存储当前字符串，一方面作为标记，另一方面，方便取用
    String leaf;


    /**
     *
     * @param n 孩子容量
     */
    public Node(int n) {
        children = new Node[n];
    }
}
