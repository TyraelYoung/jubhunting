package wang.tyrael.leetcode.createmaximum321;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
        int startLimit1 = 0,
                startLimit2 = 0,
                //inclusive
                endLimit1 = 0,
                endLimit2 = 0,
                n1 = nums1.length,
                n2 = nums2.length;

        for (int i = 0; i < k; i++) {
            int countLeft1 = n1 - startLimit1;
            int countLeft2 = n2 - startLimit2;
            int countKLeft = k - i;
            if (countKLeft > countLeft1) {
                endLimit2 = n2 - (countKLeft - countLeft1);
            }else{
                endLimit2 = nums2.length-1;
            }
            if (countKLeft > countLeft2) {
                endLimit1 = n1 - (countKLeft - countLeft2);
            }else{
                endLimit1 = nums1.length-1;
            }

            //常规路径
            //在限制中选一个最大的数
            int max = Integer.MIN_VALUE;
            int maxIndex = 0;
            boolean flag1 = true;
            //TODO 如果1、2相等，还得比较前面的数
            //TODO 还要考虑后面的数。。。
            for (int j1 = startLimit1; j1 < endLimit1 + 1; j1++) {
                if (nums1[j1] > max){
                    max = nums1[j1];
                    maxIndex = j1;
                    flag1 = true;
                }
            }
            for (int j2 = startLimit2; j2 < endLimit2 +1; j2++) {
                if (flag1 && nums2[j2] == max){
                    int g = tie(startLimit1, startLimit2, maxIndex, j2, nums1, nums2);
                    if (g == 1){
                        //还是第一组作为最大值，不用处理
                    }else{
                        max = nums2[j2];
                        maxIndex = j2;
                        flag1 = false;
                    }
                }
                if (nums2[j2] > max){
                    max = nums2[j2];
                    maxIndex = j2;
                    flag1 = false;
                }
            }
            if (flag1){
                result[i] = max;
                startLimit1 = maxIndex+1;
            }else{
                result[i] = max;
                startLimit2 = maxIndex+1;
            }
        }

        return result;
    }

    /**
     * 1,2的最大值相等,选取哪个作为最大值？
     * @param startLimit1
     * @param startLimit2
     * @param maxIndex1
     * @param maxIndex2
     * @param nums1
     * @param nums2
     * @return
     */
    public int tie(int startLimit1, int startLimit2, int maxIndex1, int maxIndex2, int[] nums1, int[] nums2){
        //则需要留下前驱中比较大的。
        PriorityQueue<Integer> heap1 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-01;
            }
        });
        PriorityQueue<Integer> heap2 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-01;
            }
        });
        for (int i = startLimit1; i < maxIndex1; i++) {
            heap1.add(nums1[i]);
        }
        for (int i = startLimit2; i < maxIndex2; i++) {
            heap2.add(nums2[i]);
        }
        while(true){
            if (heap1.isEmpty()){
                return 1;
            }
            if (heap2.isEmpty()){
                return 2;
            }
            int i1 = heap1.poll();
            int i2 = heap2.poll();
            if (i1 == i2){
                continue;
            }else{
                return i1> i2?2:1;
            }
        }

    }
}
