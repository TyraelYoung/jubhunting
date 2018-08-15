package wang.tyrael.leetcode.binarytree.bst;

import org.junit.Test;
import wang.tyrael.basic.binarytree.TreeNode;
import wang.tyrael.basic.binarytree.BinaryTreeNodeStatic;
import wang.tyrael.leetcode.binarytree.bst.uniqueii.Solution;

import java.util.List;

/**
 * @author: wangchao
 * 2018/5/7 0007
 */
public class UniqueII {
    @Test
    public void test(){
        Solution solution = new Solution();
        List<TreeNode> treeNodeList = solution.generateTrees(3);
        BinaryTreeNodeStatic.print(treeNodeList);
    }

    @Test
    public void test0(){
        Solution solution = new Solution();
        List<TreeNode> treeNodeList = solution.generateTrees(0);
        BinaryTreeNodeStatic.print(treeNodeList);
    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        List<TreeNode> treeNodeList = solution.generateTrees(1);
        BinaryTreeNodeStatic.print(treeNodeList);
    }
}
