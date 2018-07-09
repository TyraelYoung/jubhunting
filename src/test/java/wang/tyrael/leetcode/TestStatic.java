package wang.tyrael.leetcode;

import wang.tyrael.ArrayUtil;

import java.util.Collection;

public class TestStatic {
    public static void printlnResult(Object o){
        System.out.println("result:" + o);
    }

    public static void assertResult(Object answer, Object result){
        if (answer instanceof Collection){
            assetResult((Collection) answer, (Collection) result);
            return;
        }
        if (answer instanceof int[]){
            assetResultArray((int[]) answer, (int[])result);
            return;
        }
        System.out.println("应该结果:" + answer);
        System.out.println("实际结果:" + result);
        assert answer.equals(result);
    }

    public static void assetResultArray(int[] answer, int[] result){
        System.out.print("应该结果:");
        for (Object s :
                answer) {
            System.out.print(s + ",");
        }
        System.out.println();
        System.out.println("实际结果:" );
        for (Object s :
                result) {
            System.out.print(s + ",");
        }
    }

    public static void assetResult(Collection answer, Collection result){
        System.out.print("应该结果:");
        for (Object s :
                answer) {
            System.out.print(s + ",");
        }
        System.out.println();
        System.out.print("实际结果:" );
        for (Object s :
                result) {
            System.out.print(s + ",");
        }
    }
}
