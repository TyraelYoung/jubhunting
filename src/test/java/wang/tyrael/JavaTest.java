package wang.tyrael;

import com.alibaba.fastjson.JSON;
import com.google.common.math.IntMath;
import com.google.common.math.LongMath;
import wang.tyrael.leetcode.TestStatic;
import org.junit.Test;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.Semaphore;

public class JavaTest {
    @Test
    public void testVarArgs(){
        testVar(new String[]{"a", "b"});
//        testVar(Arrays.asList(new String[]{"c", "d"}));
    }

    private void testVar(String... a){
        Arrays.stream(a).forEach(s -> {
            System.out.println(s);
        });
    }

    @Test
    public void testFor(){
        int i = 10;
        for (i=11; i > 10;i--);
        System.out.println(i);
    }

    @Test
    public void testArray(){

    }

    @Test
    public void testLong(){
        Long a  = 0L;
        //!!!
        System.out.println(a.equals(0));
    }

    @Test
    public void testTmp(){
        int a = Integer.parseInt("");
        System.out.println(a);
        boolean b = Boolean.parseBoolean("");
        System.out.println(b);


//        ScheduledExecutorService;
        TreeMap treeMap = new TreeMap();
//        treeMap.ceilingKey();
//        treeMap.floorKey();
//        TreeRangeMap;
//        TreeRangeSet
    }

    @Test
    public void testMap(){
        Map<String, String> map = new HashMap<>();
//        map.putAll(null);
    }


    @Test
    public void testCalendar(){
        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date zero = calendar.getTime();
        System.out.println(calendar.getTimeInMillis());
    }

    @org.junit.Test
    public void testSwitch(){
        String s = null;
        switch (s){
            case "a":
                break;
        }
    }

    @org.junit.Test
    public void testLeft(){
        int a = 'a' - 'a';
        int b = 1<<a;
        int result = 0 | b;
        TestStatic.printlnResult(result);
    }

    @org.junit.Test
    public void testStream(){
        List<Integer> statusList = JSON.parseArray( "[201,203,204]", Integer.class);
        long countComplete = statusList.stream().filter(status -> status == 204).count();
        boolean existComplete = statusList.stream().anyMatch(status->status == 204);
        assert countComplete == 1;
        assert existComplete;

        int i = statusList.stream().filter(status -> status == 205).findAny().get();
        System.out.println(i);
    }

    @org.junit.Test
    public void testCalculate(){
        int move = 2;
        move >>=1;
        System.out.println(move);

        move = 2;
//        move-1;
        System.out.println(move);

        System.out.println("4 + 4 >>1:" + (4 + 4 >>1));

        System.out.println("sdfas".equals(null));

         List<String> listEqual = new ArrayList<>();
        listEqual.equals(new ArrayList<>());

        System.out.println((long)(10e9 + 7));

        System.out.println("'1' - '0':" + ('1' - '0'));

//        Map map =new HashMap();
//        //NullPointerException
//        int testMap = (int) map.get("test");

        Map map =new HashMap();
        //NullPointerException
        String testMapString = (String) map.get("test");
        System.out.println("testMapString:" + testMapString);

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
    }

    @Test
    public void testInt(){
        System.out.println("1>>1:" + (1>>1));
        System.out.println("1>>>1:" + (1>>>1));

        //System.out.println(Integer.parseInt(""));

        System.out.println("Integer.MAX_VALUE - Integer.MIN_VALUE:" + (Integer.MAX_VALUE - Integer.MIN_VALUE));

        System.out.println("2 * Integer.MAX_VALUE:" + 2*Integer.MAX_VALUE);
        System.out.println("2 * Integer.MIN_VALUE:" + 2*Integer.MIN_VALUE);

        System.out.println("Integer.MIN_VALUE:" + Integer.MIN_VALUE);
        System.out.println("Integer.MIN_VALUE:" + Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println("Integer.MIN_VALUE:" + Integer.toHexString(Integer.MIN_VALUE));
        System.out.println("Integer.MAX_VALUE:" + Integer.MAX_VALUE);
        System.out.println("Integer.MAX_VALUE:" + Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println("Integer.MAX_VALUE:" + Integer.toHexString(Integer.MAX_VALUE));
        System.out.println("-1:" + Integer.toBinaryString(-1));
        System.out.println("-1:" + Integer.toHexString(-1));
        System.out.println("Integer.MAX_VALUE +1:" + (Integer.MAX_VALUE +1));
        System.out.println("Integer.MAX_VALUE +Integer.MAX_VALUE:" + (Integer.MAX_VALUE +Integer.MAX_VALUE));

    }

    @Test
    public void testCalender() {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(2018, 1, 1);
        System.out.println(calendar.getTime());
        System.out.println(calendar.getTimeInMillis());
    }
}
