package wang.tyrael.leetcode.kth.primefraction786;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: wangchao
 * 2018/4/28 0028
 */
public class Solution {
    int[] A;
    int K;

    int n;

    /**
     * 构建i-1 * i-1 矩阵，
     * 注意这个矩阵实际只有左上部分，但是为了计算方便，虚拟补齐。
     * @param A
     * @param K
     * @return
     */
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        this.A = A;
        this.K = K;
        n = A.length;
        Fraction rc = bSearch();
//        System.out.println("rc:" + rc);
        return new int[]{rc.n, rc.d};

    }

    /**
     * 确认在那条对角线上，反对角线
     * @return
     */
    public Fraction bSearch(){
        int low = 0, high = n -2;//inclusive
        int count = 0;
        while (low <= high){
            int mid = low + (high-low)/2;
            count = count(mid);
//            System.out.println("mid:" + mid);
//            System.out.println("count:" + count);
            if (count == K){
                //在对角线上，对角线上最大的数
                return search(mid);
            }else if (count < K){
                //对角线左边，inclusive
                low = mid + 1;
            }else{
                high = mid-1;
            }
        }
//        System.out.println("low:" + low);
//        System.out.println("high:" + high);
        //low总是指向较大的元素？high总是指向较小的元素？
        //查询low这一行，这一列
        return search(low);
    }

    public Fraction search(int dCoordinate){
        int countPre = count(dCoordinate-1);
        //在对角线上找第thisLimit的数
        int thisLimit = K - countPre;
        List<Fraction> list = new ArrayList<>();
        //对角线
        for (int i = 0; i <= dCoordinate; i++) {
            list.add(new Fraction(A[i], A[n-2-dCoordinate + i +1]));
        }
        //TODO 这里实际上不用sort
        Collections.sort(list, new Comparator<Fraction>() {
            @Override
            public int compare(Fraction o1, Fraction o2) {
                //不可能与相等的情况出现
                return o1.calculateValue() - o2.calculateValue()<0?-1:1;
            }
        });
        return list.get(thisLimit-1);
    }


    /**
     * @param dCoordinate 反对角线坐标
     * @return 这个坐标左上方有多少个数，inclusive
     */
    int count(int dCoordinate){
        if (dCoordinate < 0){
            return 0;
        }
        return (1 + dCoordinate+1) * (dCoordinate+1) /2;
    }

    class RC {
        public int r, c;

        public RC(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "(" + r + "," + c +")";
        }
    }

    class Fraction{
        public int n, d;
//        public int r, c;

        public Fraction(int n, int d) {
            this.n = n;
            this.d = d;
        }

        public double calculateValue(){
            return n / (double)d;
        }
    }


}
