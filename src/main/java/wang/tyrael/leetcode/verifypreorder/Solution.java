package wang.tyrael.leetcode.verifypreorder;

import java.util.Arrays;
import java.util.List;

/**
 * n0 = n2+1
 * @author: wangchao
 * 2018/4/23 0023
 */
public class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.isEmpty()){
            return false;
        }

        String[] tree = preorder.split(",");

        if(isMinimal(tree)){
            return true;
        }

        if (!verifyThisLevel(tree)){
            return false;
        }
        String[] right = cutRight(tree);
        return verifyChildTree(right);
    }

    public boolean verifyChildTree(String[] preorder){
        if (preorder == null || preorder.length == 0){
            return false;
        }
        if(isMinimal(preorder)){
            return true;
        }
        if (!verifyThisLevel(preorder)){
            return false;
        }
        String[] right = cutRight(preorder);
        return verifyChildTree(right);
    }

    /**
     * 最小树，定义不严格，为处理方便
     * @param tree
     * @return
     */
    private boolean isMinimal(String[] tree){
        return tree.length == 1 && tree[0].equals("#");
    }

//    private boolean isMinimal(String tree){
//        return tree.charAt(0) != '#'
//                && tree.charAt(1) == '#'
//                && tree.charAt(2) == '#';
//    }

    private String[] cutRight(String[] tree) {
        int countN0 = 0, countN2 = 0;
        boolean flagFound = false;
        int i;
        for (i = 1; i < tree.length; i++) {
            String c = tree[i];
            if ("#".equals(c)) {
                countN0++;
            } else {
                countN2++;
            }
            if (countN0 == countN2 + 1) {
                flagFound = true;
                break;
            }
        }
        if (!flagFound) {
            return null;
        }
        return Arrays.copyOfRange(tree, i +1, tree.length);


    }

    /**
     * 验证当前树是否符合要求
     * @param tree
     */
    private boolean verifyThisLevel(String[] tree){
        int countN0 = 0, countN2 = 0;
        for (int i = 0; i < tree.length; i++) {
            String c = tree[i];
            if ("#".equals(c)){
                countN0 ++;
            }else{
                countN2++;
            }
        }
        return countN0 == countN2 +1;
    }
}
