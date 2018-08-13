package wang.tyrael.leetcode.array.sum3No15;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

/**
 * @Auther: wangchao
 * @Date: 2018/7/2 11:07
 * @Description:
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 3) return result;
        Set<List<Integer>> midResult = new HashSet<>();
        Arrays.sort(nums);
        for (int ai = 0; ai < nums.length; ai++) {
            if (ai > 0 && nums[ai] == nums[ai-1]) continue;
            int bi = ai+1, ci = nums.length-1;
            while(bi < ci){
                if (nums[bi] + nums[ci] == -nums[ai]){
                    List<Integer> oneResult = new ArrayList<>();
                    oneResult.add(nums[ai]);
                    oneResult.add(nums[bi]);
                    oneResult.add(nums[ci]);
                    oneResult.sort((o1, o2) -> {return o1-o2;});
                    midResult.add(oneResult);
                    //跳过重复的数
                    do{bi++;}while(bi < ci && nums[bi] == nums[bi-1]);
                    do{ci--;}while(bi< ci && nums[ci] == nums[ci+1]);
                    continue;
                }
                if (nums[bi] + nums[ci] < -nums[ai] ) bi ++;
                if (nums[bi] + nums[ci] > -nums[ai] ) ci --;
            }
        }
        result.addAll(midResult);
        return result;
    }
}
