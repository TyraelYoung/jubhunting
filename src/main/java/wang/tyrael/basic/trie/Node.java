package wang.tyrael.basic.trie;

/**
 * @author: wangchao
 */
public class Node {
    Node[] children;
    String leaf;


    /**
     *
     * @param n 孩子容量
     */
    public Node(int n) {
        children = new Node[n];
    }
}
