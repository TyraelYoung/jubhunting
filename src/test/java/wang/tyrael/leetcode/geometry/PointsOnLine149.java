package wang.tyrael.leetcode.geometry;

import org.junit.Test;
import wang.ArrayUtil;
import wang.tyrael.basic.Point;
import wang.tyrael.leetcode.TestStatic;
import wang.tyrael.leetcode.TestTask;

import wang.tyrael.leetcode.geometry.pointsonaline.Solution;

import java.util.ArrayList;

/**
 * @author: wangchao
 * 2018/6/8 0008
 */
public class PointsOnLine149 {
    @Test
    public void test(){
        new TestTask(new Solution(), "maxPoints", new Object[]{new Point[]{}}, 0).run();
    }
    @Test
    public void test1(){
        new TestTask(new Solution(), "maxPoints",
                new Object[]{new Point[]{
                        new Point(1,0),
                        new Point(0,1)
                }}, 2).run();
    }

    @Test
    public void test2(){
        new TestTask(new Solution(), "maxPoints",
                new Object[]{new Point[]{
                        new Point(1,0),
                        new Point(1,1)
                }}, 2).run();
    }

    @Test
    public void test3(){
        new TestTask(new Solution(), "maxPoints",
                new Object[]{ArrayUtil.parsePoint("[[1,1],[2,2],[3,3]]")}, 3).run();
    }

    @Test
    public void test4(){
        new TestTask(new Solution(), "maxPoints",
                new Object[]{ArrayUtil.parsePoint("[[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]")},
                4).run();
    }
}
