package wang.tyrael.leetcode.subsets78;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 类似四皇后回溯
 * 2. 正好对应2进制1
 *
 * @author: wangchao
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int max = (int) Math.pow(2, nums.length);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            //每个数字对应一个子集
            List<Integer> item = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i>>j & 1) > 0){
                    item.add(nums[j]);
                }
            }
            result.add(item);
        }
        return result;
    }
}
