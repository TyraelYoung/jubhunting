package wang.tyrael.leetcode.treepathsum124;

import wang.tyrael.basic.BinaryTreeNode;

/**
 * @author: wangchao
 */
public class Solution {
/**
 * Definition for a binary tree node.
 * public class BinaryTreeNode {
 *     int val;
 *     BinaryTreeNode left;
 *     BinaryTreeNode right;
 *     BinaryTreeNode(int x) { val = x; }
 * }
 */

    int max = Integer.MIN_VALUE;
    public int maxPathSum(BinaryTreeNode root) {
        halfPath(root);
        return max;
    }

    /**
     * 从根节点到页节点的单条路径最大值,
     * 和包含根节点
     * @param root
     * @return
     */
    public int halfPath(BinaryTreeNode root){
        int left  = 0;
        int right = 0;
        if(root.left != null){
            left = halfPath(root.left);
        }
        if(root.right != null){
            right = halfPath(root.right);
        }
        if (left < 0){
            left = 0;
        }
        if(right < 0){
            right = 0;
        }
        if(max < left + right + root.val){
            max = left + right + root.val;
        }

        return left < right ? right+root.val : left + root.val;
    }
}
