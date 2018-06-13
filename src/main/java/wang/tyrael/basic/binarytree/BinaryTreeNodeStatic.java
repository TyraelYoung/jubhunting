package wang.tyrael.basic.binarytree;

import wang.tyrael.ArrayUtil;

import java.util.List;

/**
 * @author: wangchao
 * 2018/5/7 0007
 */
public class BinaryTreeNodeStatic {
    public static TreeNode construct(String src){
        int[] iSrc = ArrayUtil.parse(src);
        return null;
    }

    public static void print(List<TreeNode> roots){
        System.out.print("总数：" + roots.size());
        for (TreeNode root :
                roots) {
            System.out.println("树:");
            BinaryTreeNodeStatic.print(root);
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
