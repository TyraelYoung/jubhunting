package wang.tyrael.leetcode.bst;

import org.junit.Test;
import wang.tyrael.basic.BinaryTreeNode;
import wang.tyrael.basic.BinaryTreeNodeStatic;
import wang.tyrael.leetcode.bst.uniqueii.Solution;

import java.util.List;

/**
 * @author: wangchao
 * 2018/5/7 0007
 */
public class UniqueII {
    @Test
    public void test(){
        Solution solution = new Solution();
        List<BinaryTreeNode> binaryTreeNodeList = solution.generateTrees(3);
        BinaryTreeNodeStatic.print(binaryTreeNodeList);
    }

    @Test
    public void test0(){
        Solution solution = new Solution();
        List<BinaryTreeNode> binaryTreeNodeList = solution.generateTrees(0);
        BinaryTreeNodeStatic.print(binaryTreeNodeList);
    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        List<BinaryTreeNode> binaryTreeNodeList = solution.generateTrees(1);
        BinaryTreeNodeStatic.print(binaryTreeNodeList);
    }
}
