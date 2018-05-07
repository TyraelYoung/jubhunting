package wang.tyrael.leetcode.bst;

import org.junit.Test;
import wang.tyrael.basic.TreeNode;
import wang.tyrael.basic.TreeNodeStatic;
import wang.tyrael.leetcode.bst.uniqueii.Solution;

import java.lang.annotation.Repeatable;
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
        TreeNodeStatic.print(treeNodeList);
    }

    @Test
    public void test0(){
        Solution solution = new Solution();
        List<TreeNode> treeNodeList = solution.generateTrees(0);
        TreeNodeStatic.print(treeNodeList);
    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        List<TreeNode> treeNodeList = solution.generateTrees(1);
        TreeNodeStatic.print(treeNodeList);
    }
}
