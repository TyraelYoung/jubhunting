package wang.tyrael.leetcode.array;

import org.junit.Test;
import wang.tyrael.leetcode.TestTask;
import wang.tyrael.leetcode.array.nondecreasing665.Solution;

/**
 * @Auther: wangchao
 * @Date: 2018/6/26 10:25
 * @Description:
 */
public class NonDescreasing665 {
    @Test
    public void test(){
        new TestTask(new Solution(), "checkPossibility", new Object[]{new int[]{}}, true).run();
    }

    @Test
    public void test1(){
        new TestTask(new Solution(), "checkPossibility", new Object[]{new int[]{1}}, true).run();
    }

    @Test
    public void test2(){
        new TestTask(new Solution(), "checkPossibility", new Object[]{new int[]{1, 2}}, true).run();
    }

    @Test
    public void test3(){
        new TestTask(new Solution(), "checkPossibility", new Object[]{new int[]{2, 1}}, true).run();
    }

    @Test
    public void test4(){
        new TestTask(new Solution(), "checkPossibility", new Object[]{new int[]{4, 2, 1}}, false).run();
    }

    @Test
    public void test5(){
        new TestTask(new Solution(), "checkPossibility", new Object[]{new int[]{4, 2, 3}}, true).run();
    }

    @Test
    public void test6(){
        new TestTask(new Solution(), "checkPossibility",
                new Object[]{new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE}}, true).run();
    }

    @Test
    public void test7(){
        new TestTask(new Solution(), "checkPossibility",
                new Object[]{new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE}}, true).run();
    }
}
