package wang.tyrael;

import java.util.*;

public class Test {
    @org.junit.Test
    public void test(){
        System.out.println("'1' - '0':" + ('1' - '0'));

//        Map map =new HashMap();
//        //NullPointerException
//        int testMap = (int) map.get("test");

        String s = (String)null;
        System.out.println("String s = (String)null:" + s);

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("0");
        Collections.sort(list);
        ArrayUtil.print(list);

        for (int i = 0; i < 1; i++) {
            System.out.println("hahaha:" + i);
        }

        System.out.println("-1%-2: " + (-1%-2));
        System.out.println("1%-2: " + (1%-2));
        System.out.println("-1%2: " + (-1%2));

        System.out.println("-3%-2: " + (-3%-2));
        System.out.println("3%-2: " + (3%-2));
        System.out.println("-3%2: " + (-3%2));

        System.out.println("test".substring(0, 1));
        System.out.println("test".substring(0, 0));
        System.out.println("test".substring(0, 2));

        System.out.println("Integer.MIN_VALUE:" + Integer.MIN_VALUE);
        System.out.println("Integer.MIN_VALUE:" + Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println("Integer.MAX_VALUE:" + Integer.MAX_VALUE);
        System.out.println("Integer.MAX_VALUE:" + Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println("Integer.MAX_VALUE +1:" + (Integer.MAX_VALUE +1));
        System.out.println("Integer.MAX_VALUE +Integer.MAX_VALUE:" + (Integer.MAX_VALUE +Integer.MAX_VALUE));
    }
}
