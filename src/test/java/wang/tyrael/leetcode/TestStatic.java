package wang.tyrael.leetcode;

public class TestStatic {
    public static void printlnResult(Object o){
        System.out.println("result:" + o);
    }

    public static void assertResult(Object answer, Object result){
        System.out.println("result:" + result);
        assert answer.equals(result);
    }
}
