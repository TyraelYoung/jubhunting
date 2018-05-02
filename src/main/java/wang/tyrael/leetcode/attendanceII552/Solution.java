package wang.tyrael.leetcode.attendanceII552;

public class Solution {
    public int checkRecord(int n) {
        //for n =1
        long[] stateCount = new long[7];
        stateCount[0] = 0;
        stateCount[1] = 0;
        stateCount[2] = 1;
        stateCount[3] = 0;
        stateCount[4] = 1;
        stateCount[5] = 0;
        stateCount[6] = 1;
        for (int i = 2; i <= n; i++) {
            long[] newStateCount =new  long[7];
            newStateCount[0] = stateCount[0] * 3 + stateCount[1] + stateCount[2]
                    + stateCount[3] * 2 + stateCount[5];
            newStateCount[1] = stateCount[2];
            newStateCount[2] = sum(stateCount[1] , stateCount[2] , stateCount[3] , stateCount[4] , stateCount[5] , stateCount[6]);
            newStateCount[3] = stateCount[1];
            newStateCount[4] = stateCount[6];
            newStateCount[5] = stateCount[4];
            newStateCount[6] = sum(stateCount[4] , stateCount[5] , stateCount[6]);

            stateCount = newStateCount;
        }
        return (int) sum(stateCount[1] , stateCount[2] , stateCount[3] , stateCount[4] , stateCount[5] , stateCount[6]);
    }

    public static long sum(long... a){
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            sum = sum % 1000000007;
        }
        return sum;
    }
}
