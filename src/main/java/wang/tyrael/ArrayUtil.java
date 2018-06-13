package wang.tyrael;

import com.alibaba.fastjson.JSON;
import wang.tyrael.basic.geometry.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayUtil {
    public static List<Integer> toList(int[] a) {
        List<Integer> list = new ArrayList<>();
        for (int i :
                a) {
            list.add(i);
        }
        return list;
    }


    public static int[] parse(String s) {
        List<Integer> list = JSON.parseArray(s, Integer.class);
        int[] a = new int[list.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = list.get(i);
        }
        return a;
    }

    public static String[] parseString(String s) {
        List<String> list = JSON.parseArray(s, String.class);
        String[] a = new String[list.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = list.get(i);
        }
        return a;
    }

    public static List<List<String>> parse2DString(String s) {
        List<String> ls = JSON.parseArray(s, String.class);
        List<List<String>> result = new ArrayList<>();
        for (String s1 :
                ls) {
            result.add(JSON.parseArray(s1, String.class));
        }
        return result;
    }

    public static List<List<Integer>> parse2DInteger(String s) {
        List<String> ls = JSON.parseArray(s, String.class);
        List<List<Integer>> result = new ArrayList<>();
        for (String s1 :
                ls) {
            result.add(JSON.parseArray(s1, Integer.class));
        }
        return result;
    }

    public static int[][] parse2D(String s) {
        List<String> ls = JSON.parseArray(s, String.class);
        int[][] result = new int[ls.size()][];
        for (int i = 0; i < ls.size(); i++) {
            String item = ls.get(i);
            List<Integer> lo = JSON.parseArray(item, Integer.class);
            result[i] = new int[lo.size()];
            for (int j = 0; j < lo.size(); j++) {
                result[i][j] = lo.get(j);
            }
        }
        return result;
    }

    public static Point[] parsePoint(String s) {
        List<String> ls = JSON.parseArray(s, String.class);
        Point[] result = new Point[ls.size()];
        for (int i = 0; i < ls.size(); i++) {
            String item = ls.get(i);
            List<Integer> lo = JSON.parseArray(item, Integer.class);
            result[i] = new Point(lo.get(0), lo.get(1));
        }
        return result;
    }

    public static char[][] parseChar2D(String s) {
        List<String> ls = JSON.parseArray(s, String.class);
        char[][] result = new char[ls.size()][];
        for (int i = 0; i < ls.size(); i++) {
            String item = ls.get(i);
            List<Character> lo = JSON.parseArray(item, Character.class);
            result[i] = new char[lo.size()];
            for (int j = 0; j < lo.size(); j++) {
                result[i][j] = lo.get(j);
            }
        }
        return result;
    }


    public static void printArray(int[] n) {
        for (int i : n) {
            System.out.print("" + i + ",");
        }
    }

    public static void printPoint(List<Point> n) {
        for (Point i : n) {
            System.out.print("" + i + ",");
        }
    }

    public static void printIntArray(List<int[]> list) {
        for (int[] array :
                list) {
            System.out.print("(");
            printArray(array);
            System.out.print(")");

        }
    }

    public static void print(char[][] n) {
        System.out.println("array:");
        for (int i = 0; i < n.length; i++) {
            char[] a = n[i];
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[j] + ",");
            }
            System.out.println();
        }
    }

    public static void print(int[][] n) {
        System.out.println("array:");
        for (int i = 0; i < n.length; i++) {
            int[] a = n[i];
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[j] + ",");
            }
            System.out.println();
        }
    }


    public static void print(List list) {
        for (Object s :
                list) {
            System.out.print(s + ",");
        }
    }

    public static void printInt(List<Integer> list) {
        for (Integer s :
                list) {
            System.out.print(s + ",");
        }
    }

    private void testBinSearchBig() {
        int[] nums = new int[]{1, 3, 2, 3, 1};
        Arrays.sort(nums);
        printArray(nums);
        int result = binSearchBig(nums, 2, 3, 1);
        System.out.println("****************");
        System.out.println(result);
    }


    /**
     * 从前往后，找到第一个比key大或者=的数
     * 则，前面的数，都比key小
     * TODO 改用二分查找
     *
     * @param nums  要求已排序
     * @param start
     * @param stop
     * @param key
     * @return 如果所有数都小于key，则返回stop+1
     */
    private int binSearchBig(int[] nums, int start, int stop, double key) {
        if (start == stop) {
            if (nums[start] >= key) {
                return start;
            } else {
                return stop + 1;
            }
        }
        int mid = (stop - start) / 2 + start;
        if (nums[mid] == key) {
            //可疑值在mid左边，包含
            while (mid >= start) {
                mid--;
                if (nums[mid] < key) {
                    return mid + 1;
                }
            }
            if (mid == start - 1) {
                return start;
            }
        }
        if (nums[mid] > key) {
            //可疑值在mid左边，包含
            int result = binSearchBig(nums, start, mid, key);
            return result;
        } else {
            //可疑值在mid右边，不包含

            return binSearchBig(nums, mid + 1, stop, key);
        }
    }
}
