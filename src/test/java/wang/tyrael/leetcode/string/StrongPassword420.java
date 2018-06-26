package wang.tyrael.leetcode.string;

import org.junit.Test;
import wang.tyrael.leetcode.TestTask;
import wang.tyrael.leetcode.string.strongpassword420.Solution;

public class StrongPassword420 {
    @Test
    public void test(){
        new TestTask(new Solution(), "strongPasswordChecker", new Object[]{"aa"}, 4).run();
    }

    @Test
    public void test1(){
        new TestTask(new Solution(), "strongPasswordChecker", new Object[]{"aaa111"}, 2).run();
    }

    @Test
    public void test2(){
        new TestTask(new Solution(), "strongPasswordChecker", new Object[]{""}, 6).run();
    }

    @Test
    public void test3(){
        new TestTask(new Solution(), "strongPasswordChecker", new Object[]{"1010101010aaaB10101010"}, 2).run();
    }

}
