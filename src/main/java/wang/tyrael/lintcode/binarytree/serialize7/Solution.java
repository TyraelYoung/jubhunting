package wang.tyrael.lintcode.binarytree.serialize7;

import wang.tyrael.basic.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: wangchao
 * @Date: 2018/8/14 09:38
 * @Description:
 */
public class Solution {

    public String serialize(TreeNode root) {
        // write your code here
        //先用List把node存住，相当于于只进不出的支持空值的队列
        List<TreeNode> list = new LinkedList<>();
        list.add(root);
        //1-based
        int parentLevel = 1, parentStart = 0, parentEnd = (1 << parentLevel)-1;//exclusive
        boolean flagParentEmpty = root == null?true:false;
        while (!flagParentEmpty){
            //一行一行处理
            boolean childrenEmpty = true;
            for (int i = parentStart; i < parentEnd; i++) {
                TreeNode parent = list.get(i);
                if (parent == null){
                    list.add(null);
                    list.add(null);
                }else{
                    list.add(parent.left);
                    list.add(parent.right);
                    if (parent.left != null || parent.right != null) childrenEmpty = false;
                }
            }

            //下一轮的变量
            parentLevel ++;
            parentStart = parentEnd;
            parentEnd = (1<<parentLevel)-1;
            flagParentEmpty = childrenEmpty;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            TreeNode treeNode = list.get(i);
            if (treeNode ==null) stringBuilder.append("#");
            else stringBuilder.append(treeNode.val);
            stringBuilder.append(",");
        }
        return stringBuilder.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        //根先序构造
        if (data ==null || data.isEmpty()) return null;
        String[] sValues = data.split(",");
        return construct(sValues, 0);
    }

    private TreeNode construct(String[] sValues, int thisIndex){
        String sValue = sValues[thisIndex];
        sValue = sValue.trim();
        if (sValue.equals("#")) return null;
        int value = Integer.parseInt(sValue);
        TreeNode treeNode = new TreeNode(value);
        treeNode.left = construct(sValues, (thisIndex << 1) +1);
        treeNode.right = construct(sValues, (thisIndex <<1) +2);
        return treeNode;
    }
}
