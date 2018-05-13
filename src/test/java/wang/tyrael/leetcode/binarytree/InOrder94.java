package wang.tyrael.leetcode.binarytree;

import org.junit.Test;
import wang.tyrael.leetcode.binarytree.inorder94.Solution;
import wang.tyrael.leetcode.binarytree.inorder94.TreeNode;

import java.util.List;

public class InOrder94 {
    @Test
    public void test(){
        Solution solution = new Solution();
        List<Integer> result = solution.inorderTraversal(null);
        assert result.isEmpty();
    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        List<Integer> result = solution.inorderTraversal(new TreeNode(0));
        assert result.get(0) == 0;
    }
}
