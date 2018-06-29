package wang.tyrael.leetcode.numberset;

import org.junit.Test;
import wang.tyrael.ArrayUtil;
import wang.tyrael.leetcode.TestTask;
import wang.tyrael.leetcode.numberset.sameaverage805.Solution;

/**
 * @Auther: wangchao
 * @Date: 2018/6/27 15:04
 * @Description:
 */
public class SameAverage805 {
    @Test
    public void test(){
        new TestTask(new Solution(), "splitArraySameAverage",
                new Object[]{new int[]{}}, false).run();
    }

    @Test
    public void test1(){
        new TestTask(new Solution(), "splitArraySameAverage",
                new Object[]{ArrayUtil.parse("[1,2,3,4,5,6,7,8]")}, true).run();
    }

    @Test
    public void test2(){
        new TestTask(new Solution(), "splitArraySameAverage",
                new Object[]{ArrayUtil.parse("[1,2,3]")}, true).run();
    }

    @Test
    public void test3(){
        //[18,0,16,2]
        new TestTask(new Solution(), "splitArraySameAverage",
                new Object[]{ArrayUtil.parse("[18,0,16,2]")}, true).run();
    }
}
