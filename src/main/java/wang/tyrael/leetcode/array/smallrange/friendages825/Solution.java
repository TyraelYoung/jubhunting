package wang.tyrael.leetcode.array.smallrange.friendages825;

/**
 * @author: wangchao
 * 2018/5/3 0003
 */
public class Solution {

    int countAge[] = new int[121];

    public int numFriendRequests(int[] ages) {
        for (int age :
                ages) {
            countAge[age] ++;
        }
        int reuslt = 0;
        for (int i = 1; i < 121; i++) {
            int bmin = (int) (0.5 * i + 7);
            int bmax = i; //exclusive
            int friendCount = 0;
            for (int j = bmin+1; j <= bmax; j++) {
                friendCount += countAge[j];
            }

            //减去自己
            if (friendCount > 0){
                friendCount--;
            }
            reuslt += countAge[i] * friendCount;
        }
        return reuslt;
    }
}
