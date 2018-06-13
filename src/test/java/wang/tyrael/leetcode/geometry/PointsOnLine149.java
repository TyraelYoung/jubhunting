package wang.tyrael.leetcode.geometry;

import org.junit.Test;
import wang.tyrael.leetcode.TestTask;

import wang.tyrael.leetcode.geometry.pointsonaline.Point;
import wang.tyrael.leetcode.geometry.pointsonaline.Solution;

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
                new Object[]{Point.parsePoint("[[1,1],[2,2],[3,3]]")}, 3).run();
    }

    @Test
    public void test4(){
        new TestTask(new Solution(), "maxPoints",
                new Object[]{Point.parsePoint("[[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]")},
                4).run();
    }

    //[[0,0],[94911151,94911150],[94911152,94911151]]
    @Test
    public void test5(){
        new TestTask(new Solution(), "maxPoints",
                new Object[]{Point.parsePoint("[[0,0],[94911151,94911150],[94911152,94911151]]")},
                2).run();
    }

    //[[0,0],[94911151,94911150],[94911152,94911151]]
    @Test
    public void test6(){
        new TestTask(new Solution(), "maxPoints",
                new Object[]{Point.parsePoint("[[0,0],[0,0]]")},
                2).run();
    }

    @Test
    public void test7(){
        new TestTask(new Solution(), "maxPoints",
                new Object[]{Point.parsePoint("[[0,0]]")},
                1).run();
    }

    //[[4,0],[4,-1],[4,5]]
    @Test
    public void test8(){
        new TestTask(new Solution(), "maxPoints",
                new Object[]{Point.parsePoint("[[4,0],[4,-1],[4,5]]")},
                3).run();
    }

    //[[1,1],[1,1],[1,1]]
    @Test
    public void test9(){
        new TestTask(new Solution(), "maxPoints",
                new Object[]{Point.parsePoint("[[1,1],[1,1],[1,1]]")},
                3).run();
    }
}
