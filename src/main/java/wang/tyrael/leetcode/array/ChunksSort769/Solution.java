package wang.tyrael.leetcode.array.ChunksSort769;

public class Solution {
    public int maxChunksToSorted(int[] arr) {
        int chunkCount = 0;
        int start = 0, end = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > end) {
                end = arr[i];
            }
            if (i == end) {
                chunkCount++;
                start = i + 1;
                end = i + 1;
            }
        }
        return chunkCount;
    }
}
