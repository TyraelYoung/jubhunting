package wang.tyrael.leetcode;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import wang.tyrael.ArrayUtil;
import wang.tyrael.leetcode.splitArray805.Solution;

public class SpliteArray805 {
    @Test
    public void test(){
        Solution solution = new Solution();
        int[] A ;
        boolean result ;
//        A = ArrayUtil.parse("[1,2,3,4,5,6,7,8]");
//        result = solution.splitArraySameAverage(A);
//        System.out.println("[1,2,3,4,5,6,7,8]:" + result);

        //[2,0,5,6,16,12,15,12,4]
//        A = ArrayUtil.parse("[2,0,5,6,16,12,15,12,4]");
//        result = solution.splitArraySameAverage(A);
//        System.out.println("[2,0,5,6,16,12,15,12,4]:" + result);
//
//        //[0]
//        A = ArrayUtil.parse("[0]");
//        result = solution.splitArraySameAverage(A);
//        System.out.println("[0]:false:" + result);

        //[18,0,16,2]
//        A = ArrayUtil.parse("[18,0,16,2]");
//        result = solution.splitArraySameAverage(A);
//        System.out.println("[18,0,16,2]:true:" + result);

        //[3,1,2]
        A = ArrayUtil.parse("[3,1,2]");
        result = solution.splitArraySameAverage(A);
        System.out.println("[3,1,2]:true:" + result);

        //[4, 4, 4, 4, 4, 4, 5, 4, 4, 4, 4, 4, 4, 5]
        A = ArrayUtil.parse("[4, 4, 4, 4, 4, 4, 5, 4, 4, 4, 4, 4, 4, 5]");
        result = solution.splitArraySameAverage(A);
        System.out.println("[4, 4, 4, 4, 4, 4, 5, 4, 4, 4, 4, 4, 4, 5]:true:" + result);

        //[6,8,18,3,1]
        A = ArrayUtil.parse("[6,8,18,3,1]");
        result = solution.splitArraySameAverage(A);
        System.out.println("[6,8,18,3,1]:false:" + result);

//        A = ArrayUtil.parse("[9990,\n" +
//                "        30,\n" +
//                "        30,\n" +
//                "        30,\n" +
//                "        30,\n" +
//                "        30,\n" +
//                "        30,\n" +
//                "        30,\n" +
//                "        30,\n" +
//                "        30,\n" +
//                "        30,\n" +
//                "        30,\n" +
//                "        30,\n" +
//                "        30,\n" +
//                "        30,\n" +
//                "        30,\n" +
//                "        30,\n" +
//                "        30,\n" +
//                "        30,\n" +
//                "        30,\n" +
//                "        30,\n" +
//                "        30,\n" +
//                "        30,\n" +
//                "        30,\n" +
//                "        30,\n" +
//                "        30,\n" +
//                "        30,\n" +
//                "        30,\n" +
//                "        30,\n" +
//                "        30]");
//        result = solution.splitArraySameAverage(A);
//        System.out.println("[9990]:true:" + result);


    }
}
