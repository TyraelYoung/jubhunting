package wang.tyrael.basic.trie;

public class Node {
    Node[] children = new Node[26];
    String leaf;

    public Node(int n) {
        this.children = new Node[26];
        this.leaf = leaf;
    }
}
