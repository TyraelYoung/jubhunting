package wang.tyrael.leetcode.string.consective.removeboxes546;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int[][] countPoints;

    public int removeBoxes(int[] boxes) {
        if (boxes.length == 0){
            return 0;
        }
        countPoints =new int[boxes.length][boxes.length+1];
        int reuslt = step(boxes, 0, boxes.length);
        return reuslt;
    }


    public int step(int[] boxes, int start, int end){
        if (start == end){
            return 0;
        }
        if (countPoints[start][end] != 0){
            return countPoints[start][end];
        }
        int startValue = boxes[start];
        int countConsecutive = 0;
        int maxResult = Integer.MIN_VALUE;
        List<Integer> sameValueIndexes = findIndex(startValue, start, end, boxes);
        for (int i = 0; i < sameValueIndexes.size(); i++) {
            countConsecutive++;
            int candidate = countConsecutive * countConsecutive;
            for (int j = 1; j <= i; j++) {
                candidate += step(boxes,
                        sameValueIndexes.get(j-1) +1,
                        sameValueIndexes.get(j));
            }
            candidate += step(boxes, sameValueIndexes.get(i)+1, end);
            if (candidate > maxResult){
                maxResult = candidate;
            }
        }
        countPoints[start][end] = maxResult;
        return maxResult;
    }

    /**
     *
     * @param value
     * @param start
     * @param end exclisive
     * @param boxes
     * @return
     */
    public List<Integer> findIndex(int value, int start, int end, int[] boxes){
        List<Integer> result = new ArrayList<>();
        for (int i = start; i < end; i++) {
            if (boxes[i] == value){
                result.add(i);
            }
        }
        return result;
    }
}
