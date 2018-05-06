package wang.tyrael.leetcode.linked;

import org.junit.Test;
import wang.tyrael.basic.ListNode;
import wang.tyrael.basic.ListNodeStatic;
import wang.tyrael.leetcode.linked.sort148.Solution;

public class Sort148 {
    @Test
    public void test(){
        Solution solution = new Solution();
        ListNode result = solution.sortList(ListNodeStatic.parse("[4,2,1,3]"));
        ListNodeStatic.print(result);
    }

    @Test
    public void test0(){
        Solution solution = new Solution();
        ListNode result = solution.sortList(ListNodeStatic.parse("[]"));
        ListNodeStatic.print(result);
    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        ListNode result = solution.sortList(ListNodeStatic.parse("[1]"));
        ListNodeStatic.print(result);
    }
}
