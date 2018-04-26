package wang.tyrael.leetcode.range;

import org.junit.Test;
import wang.tyrael.leetcode.range.insertinterval57.Interval;
import wang.tyrael.leetcode.range.insertinterval57.IntervalStatic;
import wang.tyrael.leetcode.range.insertinterval57.Solution;

import java.util.List;

/**
 * @author: wangchao
 * 2018/4/26 0026
 */
public class InsertInterval57 {
    @Test
    public void test(){
        Solution solution = new Solution();
        List<Interval> result = solution.insert(
                IntervalStatic.parseForList("[[1,3],[6,9]]"),
                new Interval("[2,5]"));
        System.out.println("[[1,5],[6,9]]:");
        IntervalStatic.printList(result);
        System.out.println();
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        List<Interval> result = solution.insert(
                IntervalStatic.parseForList("[[1,2],[3,5],[6,7],[8,10],[12,16]]"),
                new Interval("[4,8]"));
        System.out.println("[[1,2],[3,10],[12,16]]:");
        IntervalStatic.printList(result);
        System.out.println();
    }

    @Test
    public void test3(){
        Solution solution = new Solution();
        List<Interval> result = solution.insert(
                IntervalStatic.parseForList("[]"),
                new Interval("[4,8]"));
        System.out.println("[4,8]:");
        IntervalStatic.printList(result);
        System.out.println();
    }

    @Test
    public void test4(){
        Solution solution = new Solution();
        List<Interval> result = solution.insert(
                IntervalStatic.parseForList("[]"),
                new Interval());
        System.out.println(":");
        IntervalStatic.printList(result);
        System.out.println();
    }

    @Test
    public void test5(){
        Solution solution = new Solution();
        List<Interval> result = solution.insert(
                IntervalStatic.parseForList("[[1,5]]"),
                new Interval("[2,3]"));
        System.out.println("[[1,5]]:");
        IntervalStatic.printList(result);
        System.out.println();
    }

    @Test
    public void test6(){
        Solution solution = new Solution();
        List<Interval> result = solution.insert(
                IntervalStatic.parseForList("[[1,5]]"),
                new Interval("[0,5]"));
        System.out.println("[[0,5]]:");
        IntervalStatic.printList(result);
        System.out.println();
    }
}
