package wang.tyrael.leetcode;

import org.junit.Test;
import wang.tyrael.leetcode.reachingPoints.Solution;

public class ReachingPoints {
    @Test
    public void test(){
        Solution solution = new Solution();
        boolean result;
        result = solution.reachingPoints(1, 1, 3, 5);
        System.out.println("true:" + result);

        result = solution.reachingPoints(1, 1, 2, 2);
        System.out.println("false:" + result);

        result = solution.reachingPoints(1, 1, 1, 1);
        System.out.println("true:" + result);


//        35
//        13
//        455955547
//        420098884

        result = solution.reachingPoints(35, 13, 455955547, 420098884);
        System.out.println("false:" + result);

        result = solution.reachingPoints(1, 8, 4, 15);
        System.out.println("false:" + result);

//        1
//        1
//        1000000000
//        1
        result = solution.reachingPoints(1, 1, 1000000000, 1);
        System.out.println("true:" + result);

        result = solution.reachingPoints(9, 10, 9, 19);
        System.out.println("true:" + result);
    }
}
