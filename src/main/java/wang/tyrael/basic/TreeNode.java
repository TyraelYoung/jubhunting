package wang.tyrael.basic;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    public String word;
    public int index;
    //调试使用
    public List<TreeNode> children = new ArrayList<>();
    public TreeNode parent;

    public TreeNode(int index) {
        this.index = index;
    }

    public TreeNode(String word, int index) {
        this.word = word;
        this.index = index;
    }

    public TreeNode(String word, int index, TreeNode parent) {
        this.word = word;
        this.index = index;
        this.parent = parent;
    }

    public TreeNode(String child, TreeNode next) {
        this.word = child;
        this.parent = next;
    }

    @Override
    public String toString() {
        return word;
    }


}
