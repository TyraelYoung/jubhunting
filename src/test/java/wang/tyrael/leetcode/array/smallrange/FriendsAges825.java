package wang.tyrael.leetcode.array.smallrange;

import org.junit.Test;
import wang.ArrayUtil;
import wang.tyrael.leetcode.TestStatic;
import wang.tyrael.leetcode.array.smallrange.friendages825.Solution;

/**
 * @author: wangchao
 * 2018/5/3 0003
 */
public class FriendsAges825 {
    @Test
    public void test0(){
        Solution solution = new Solution();
        int result = solution.numFriendRequests(ArrayUtil.parse("[16,16]"));
        TestStatic.printlnResult(result);
        assert result == 2;
    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        int result = solution.numFriendRequests(ArrayUtil.parse("[16,17,18]"));
        TestStatic.printlnResult(result);
        assert result == 2;
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        int result = solution.numFriendRequests(ArrayUtil.parse("[20,30,100,110,120]"));
        TestStatic.printlnResult(result);
        assert result == 3;
    }

    @Test
    public void test3(){
        Solution solution = new Solution();
        int result = solution.numFriendRequests(ArrayUtil.parse("[]"));
        TestStatic.printlnResult(result);
        assert result == 0;
    }

    @Test
    public void test4(){
        Solution solution = new Solution();
        int result = solution.numFriendRequests(ArrayUtil.parse("[108,115,5,24,82]"));
        TestStatic.printlnResult(result);
        assert result == 3;
    }
}
