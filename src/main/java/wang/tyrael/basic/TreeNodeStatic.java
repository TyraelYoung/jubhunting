package wang.tyrael.basic;

import java.util.List;

/**
 * @author: wangchao
 * 2018/5/7 0007
 */
public class TreeNodeStatic {
    public static void print(List<TreeNode> roots){
        System.out.print("总数：" + roots.size());
        for (TreeNode root :
                roots) {
            System.out.println("树:");
            TreeNodeStatic.print(root);
        }
    }

    public static void print(TreeNode root){
        print(root, 0);
    }

    private static void print(TreeNode root, int level){
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
