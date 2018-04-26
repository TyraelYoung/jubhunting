package wang.tyrael.leetcode.recoverbst;

/**
 * @author: wangchao
 * 2018/4/25 0025
 */
public class Solution {
    class Pair{
        int min;
        int max;

        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }


    TreeNode p1, p2;


    public void recoverTree(TreeNode root) {
        //中根序比较前后的值，发现第一个有问题的地方
    }

    /**
     * 返回子树的最大值最小值
     * @param treeNode
     * @return
     */
    public Pair findProblem(TreeNode treeNode){
        if (treeNode == null) {
            return null;
        }

        Pair pairLeft = findProblem(treeNode.left);
        if (p1 != null){

        }

        Pair pairRight = findProblem(treeNode.right);


    }
}
