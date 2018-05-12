package wang.tyrael.basic;

public class TreeNodeStatic {
    public static void printTree(TreeNode root) {
        print(root, 0);
    }

    private static void print(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < level; i++) {
            System.out.print("*");
        }
        System.out.println(root);
        for (TreeNode node :
                root.children) {
            print(node, level + 1);
        }
    }
}
