package wang.tyrael.leetcode.beautifularrangementii667;

public class Solution {
    public int[] constructArray(int n, int k) {
        int[] result = new int[n];
        int i = n - k -1;
        for (int j = 0; j < i; j++) {
            result[j] = j+1;
        }

        int m = (n -i)/2;
        int index = i;
        for (int j = 1; j <= m; j++) {
           result[index] = i + j;
           result[index + 1] = n -j +1;
           index += 2;
        }

        if( (n-i) % 2 ==1){
            result[n-1] = i+m+1;
        }

        return result;
    }
}
