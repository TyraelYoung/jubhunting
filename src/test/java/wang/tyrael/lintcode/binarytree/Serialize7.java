package wang.tyrael.lintcode.binarytree;

import org.junit.Test;
import wang.tyrael.basic.binarytree.TreeNode;
import wang.tyrael.leetcode.TestStatic;
import wang.tyrael.lintcode.binarytree.serialize7.Solution;

/**
 * @Auther: wangchao
 * @Date: 2018/8/15 10:05
 * @Description:
 */
public class Serialize7 {
    @Test
    public void test(){
        Solution solution = new Solution();
        String s = "";
        TreeNode root = solution.deserialize(s);
        String serial = solution.serialize(root);
        TestStatic.assertAndPrint("#,", serial);
    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        String s = null;
        TreeNode root = solution.deserialize(s);
        String serial = solution.serialize(root);
        TestStatic.assertAndPrint("#,", serial);
    }

    @Test
    public void test3(){
        Solution solution = new Solution();
        String s = "1, #, #";
        TreeNode root = solution.deserialize(s);
        String serial = solution.serialize(root);
        TestStatic.assertAndPrint(s, serial);
    }

    @Test
    public void test4(){
        Solution solution = new Solution();
        String s = "1, #, 2, #, #, #, #";
        TreeNode root = solution.deserialize(s);
        String serial = solution.serialize(root);
        TestStatic.assertAndPrint(s, serial);
    }
}
