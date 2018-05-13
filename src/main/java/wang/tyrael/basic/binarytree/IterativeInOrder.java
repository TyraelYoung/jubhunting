package wang.tyrael.basic.binarytree;

import java.util.Stack;

public class IterativeInOrder {
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
