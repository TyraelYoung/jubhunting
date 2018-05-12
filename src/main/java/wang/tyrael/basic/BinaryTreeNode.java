package wang.tyrael.basic;

public class BinaryTreeNode {
    public int val;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "" + val;
    }
}
