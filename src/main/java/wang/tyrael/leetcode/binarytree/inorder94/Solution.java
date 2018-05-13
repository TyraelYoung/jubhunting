package wang.tyrael.leetcode.binarytree.inorder94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        InOrder worker = new InOrder();
        worker.run(root);
        return worker.result;
    }
}

class IterativeInOrder {
    Stack<TreeNode> stack = new Stack<>();

    public void run(TreeNode root){
        //初始化
        pushAll(root);
        while(!stack.empty()){
            TreeNode visit = stack.pop();
            doWork(visit);
            pushAll(visit.right);
        }
    }

    public void doWork(TreeNode visit){
        System.out.println(visit.val);
    }

    /**
     * 沿左树，一直压到叶子
     * @param root
     */
    private void pushAll(TreeNode root){
        TreeNode thisNode = root;
        while(thisNode!= null){
            stack.push(thisNode);
            thisNode = thisNode.left;
        }
    }
}

class InOrder extends IterativeInOrder {
    public List<Integer> result = new ArrayList<>();
    @Override
    public void doWork(TreeNode visit) {
        result.add(visit.val);
    }

}
