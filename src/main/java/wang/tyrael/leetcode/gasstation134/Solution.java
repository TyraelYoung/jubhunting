package wang.tyrael.leetcode.gasstation134;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0)
            return 0;
        int[] left = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            left[i] = gas[i] - cost[i];
        }
        //假设最后一个为终点
        int[] t = new int[gas.length];
        t[gas.length -1] = left[gas.length -1];
        for (int i = gas.length-2; i >= 0; i--) {
            t[i] = left[i] + t[i+1];
        }
        int max = Integer.MIN_VALUE, maxIndex = -1;
        for (int i = 0; i < t.length; i++) {
            if (t[i] > max){
                max = t[i];
                maxIndex = i;
            }
        }

        return t[0] >= 0? maxIndex: -1;
    }
}
