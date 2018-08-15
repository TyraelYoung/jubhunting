package wang.tyrael.leetcode;

import java.util.Collection;

public class TestStatic {
    public static void printlnResult(Object o){
        System.out.println("result:" + o);
    }

    public static void assertAndPrint(Object expect, Object result){
        if (expect instanceof Collection){
            printCollection((Collection) expect, (Collection) result);
            return;
        }
        if (expect instanceof int[]){
            assetAndPrintArray((int[]) expect, (int[])result);
            return;
        }
        System.out.println("应该结果:" + expect);
        System.out.println("实际结果:" + result);
        assert expect.equals(result);
    }

    public static void assetAndPrintArray(int[] answer, int[] result){
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

    public static void printCollection(Collection answer, Collection result){
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
