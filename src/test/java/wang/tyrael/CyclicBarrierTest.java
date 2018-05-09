package wang.tyrael;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * @author: wangchao
 * 2018/5/8 0008
 */
public class CyclicBarrierTest {
    static CyclicBarrier c = new CyclicBarrier(2);

    @Test
    public void test() {
        System.out.println("test");
        int total = 2;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(total);
        for (int i = 0; i < total; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int id = new Random().nextInt();
                    System.out.println("" + id);
                }
            }).start();
        }
    }

//    public static void main(String[] args) {
//        new CyclicBarrierTest().test();
//    }
}
