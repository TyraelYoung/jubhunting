package wang.tyrael.leetcode.countsmaller315;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Solution {
    int[] tree;

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0){
            return result;
        }

        //想办法构建一个bit，来不断计数】
        //数组范围：min-max
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int item :
                nums) {
            if (min > item){
                min = item;
            }
        }
        //映射数组
        //valueToIndex
        int[] map = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            //bit不支持0索引位置，所以+1
            map[i] = nums[i]-min +1;
            if(map[i] > max){
                max = map[i];
            }

        }
        //最大索引


        //0-(max-min)
        tree = new int[max +1];
        //从后往前，逐个计数
        for (int i = nums.length-1; i >=0; i--) {
            int treeIndex = map[i];
            result.add(0, sum(treeIndex-1));
            add(treeIndex);
        }
        return result;
    }

    /**
     * 往后所有受影响的位置
     * @param index
     */
    void add(int index){
        int i = index;
        while (i < tree.length){
            tree[i] ++;
            i = i + (i & (-i));
        }
    }

    int sum(int index){
        int sum = 0;
        for (int i = index; i > 0 ; i -= i&(-i)) {
            sum += tree[i];
        }
        return sum;
    }
}
