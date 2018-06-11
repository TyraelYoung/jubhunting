package wang.tyrael.leetcode.array;

import org.junit.Test;
import wang.ArrayUtil;
import wang.tyrael.leetcode.TestTask;
import wang.tyrael.leetcode.array.containsduplicate3.Solution;

/**
 * @author: wangchao
 * 2018/6/11 0011
 */
public class ContainsDuplicate3 {
    @Test
    public void test(){
        new TestTask(new Solution(), "containsNearbyAlmostDuplicate",
                new Object[]{ArrayUtil.parse("[1,2,3,1]"), 3, 0}, true).run();
    }

    @Test
    public void test1(){
        new TestTask(new Solution(), "containsNearbyAlmostDuplicate",
                new Object[]{ArrayUtil.parse("[1,2,3,1]"), 3, 0}, true).run();
    }

    @Test
    public void test2(){
        new TestTask(new Solution(), "containsNearbyAlmostDuplicate",
                new Object[]{ArrayUtil.parse("[1,0,1,1]"), 1, 2}, true).run();
    }

    @Test
    public void test3(){
        new TestTask(new Solution(), "containsNearbyAlmostDuplicate",
                new Object[]{ArrayUtil.parse("[1,5,9,1,5,9]"), 2, 3}, false).run();
    }
}
