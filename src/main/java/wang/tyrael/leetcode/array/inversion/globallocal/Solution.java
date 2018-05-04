package wang.tyrael.leetcode.array.inversion.globallocal;

/**
 * @author: wangchao
 * 2018/5/4 0004
 */
public class Solution {
    public boolean isIdealPermutation(int[] A) {
        if (A.length <= 1){
            return true;
        }
        for (int i = 1; i < A.length; i++) {
            if (A[i-1] - A[i] >=2){
                return false;
            }
        }
        return true;
    }
}
