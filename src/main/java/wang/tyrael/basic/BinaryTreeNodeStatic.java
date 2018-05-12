package wang.tyrael.basic;

import java.util.List;

/**
 * @author: wangchao
 * 2018/5/7 0007
 */
public class BinaryTreeNodeStatic {
    public static void print(List<BinaryTreeNode> roots){
        System.out.print("总数：" + roots.size());
        for (BinaryTreeNode root :
                roots) {
            System.out.println("树:");
            BinaryTreeNodeStatic.print(root);
        }
    }

    public static void print(BinaryTreeNode root){
        print(root, 0);
    }

    private static void print(BinaryTreeNode root, int level){
        if (root == null){
            return;
        }
        for (int i = 0; i < level; i++) {
            System.out.print("-");
        }
        System.out.println(root);
        print(root.left, level+1);
        print(root.right, level+1);
    }
}
