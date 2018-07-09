package wang.tyrael.leetcode.bst.validatebst98;

/**
 * @Auther: wangchao
 * @Date: 2018/7/9 18:29
 * @Description:
 */
public class Solution {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        ChildData childData = isValid(root);
        return  childData != null;
    }

    public ChildData isValid(TreeNode root){
        if (root == null) return null;
        ChildData leftData = null, rightData = null;
        if (root.left != null) {
            leftData = isValid(root.left);
            if (leftData == null) return null;
            if (leftData.max >= root.val) return null;
        }
        if (root.right != null){
            rightData = isValid(root.right);
            if (rightData == null) return null;
            if (rightData.min <= root.val) return null;
        }
        ChildData childData = new ChildData();
        childData.min = leftData == null? root.val: leftData.min;
        childData.max = rightData == null ? root.val: rightData.max;
        return childData;
    }
}

class ChildData{
    int min, max;
}
