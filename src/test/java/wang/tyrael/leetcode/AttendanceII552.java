package wang.tyrael.leetcode;

import org.junit.Test;
import wang.tyrael.leetcode.attendanceII552.Solution;


public class AttendanceII552 {
    @Test
    public void test(){
        Solution solution = new Solution();
        int result = solution.checkRecord(1);
        System.out.println("result:" + result);
        assert result == 3;
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        int result = solution.checkRecord(2);
        System.out.println("result:" + result);
        assert result == 8;
    }

    @Test
    public void test3(){
        Solution solution = new Solution();
        int result = solution.checkRecord(3);
        System.out.println("result:" + result);
//        assert result == 8;
    }

    @Test
    public void test100(){
        Solution solution = new Solution();
        int result = solution.checkRecord(100);
        System.out.println("result:" + result);
        assert result == 985598218;
    }
}
