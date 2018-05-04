package wang.tyrael.leetcode.splitArray805;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean splitArraySameAverage(int[] A) {
//        ArrayUtil.printArray(A);
        if(A.length < 2){
            return false;
        }
        List<Integer> list = new ArrayList<>();
        for (int i :
                A) {
            list.add(i);
        }
        double a = MathUtil.average(list);
        int sum = MathUtil.sum(list);
        int n = list.size();

        //i个数，和为 i*a
        for (int i = 1; i <= list.size()/2; i++) {
            //System.out.println("i:" + i);
            double sumSub = i * a;
            if(sum * i % n != 0){
                //非整数
                continue;
            }

            if(find(i, sum * i / n,list)){
                return true;
            }
        }
        return false;
    }

    /**
     * 是否可以从A中中找到n个数，和为sum
     *
     * o n*n
     * @param n
     * @param sum
     * @param list size 大于n
     * @return
     */
    public boolean find(int n, int sum, List<Integer> list){
//        System.out.println("n:" + n);
//        System.out.println("sum:" + sum);
        if(sum < 0){
            return false;
        }
        if(sum ==0){
            if(n == 0){
                return true;
            }
        }
        if(sum > 0){
            if(n == 0){
                return  false;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            List<Integer> list1 = new ArrayList(list);
            int r = list1.remove(i);
            if (find(n-1, sum-r, list1)){
                return true;
            }
        }

        return false;
    }
}

 class MathUtil {
    public static double average(List<Integer> candidate){
        return sum(candidate) / (double)candidate.size();
    }

    public static int sum(List<Integer> candidate){
        int sum = 0;
        for (int i :
                candidate) {
            sum += i;
        }
        return sum;
    }}
