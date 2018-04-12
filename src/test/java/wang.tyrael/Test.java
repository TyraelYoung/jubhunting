package wang.tyrael;

import java.util.PriorityQueue;

public class Test {
    @org.junit.Test
    public void test(){
        for (int i = 0; i < 1; i++) {
            System.out.println("hahaha:" + i);
        }

        System.out.println("test".substring(0, 1));
        System.out.println("test".substring(0, 0));
        System.out.println("test".substring(0, 2));

        System.out.println("Integer.MAX_VALUE +1:" + (Integer.MAX_VALUE +1));
        System.out.println("Integer.MAX_VALUE +Integer.MAX_VALUE:" + (Integer.MAX_VALUE +Integer.MAX_VALUE));
    }
}
