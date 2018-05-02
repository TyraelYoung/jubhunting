package wang.tyrael.leetcode.array.arithmetic.slicesii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    //去重模式
    List<Map<Integer, Integer>> lengthArithmetic = new ArrayList<>();
    //以A[c]，A[r]结尾的等差数列个数
    //不去重模式
    int[][] indexdiffToCount;

    public int numberOfArithmeticSlices(int[] A) {

        int count = 0;
        //for A[0]
        lengthArithmetic.add(new HashMap<>());
        indexdiffToCount = new int[A.length][A.length];

        for (int i = 1; i < A.length; i++) {
            Map<Integer, Integer> diffToCount = new HashMap();
            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j];
                Integer integer = lengthArithmetic.get(j).get(diff);
                if (integer == null){
                    diffToCount.put(diff, 2);
                }else{
                    diffToCount.put(diff, integer +1);
                    //以A[j]，A[i]结尾的等差数列个数超过3个，计算一下count
                    count += integer -1;
                }
            }
            lengthArithmetic.add(diffToCount);
        }
        return count;
    }
}
