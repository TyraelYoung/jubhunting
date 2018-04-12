package wang.tyrael.leetcode.largestnumber179;

import java.util.*;

/**
 * @author: wangchao
 */
public class Solution {
    public String largestNumber(int[] nums) {
        List<String> list = toList(nums);
        Collections.sort(list, (o1, o2) -> {
            String s1 = o1 + o2;
            String s2 = o2 + o1;
//                int i1 = Integer.parseInt(s1);
//                int i2 = Integer.parseInt(s2);
            return -s1.compareTo(s2);
        });
        String result = toString(list);
        result = handl0(result);
        return result;
    }

    String handl0(String result){
        if (result.startsWith("0")){
            return "0";
        }
        return result;
    }

    String toString(List<String> list){
        StringBuilder stringBuilder = new StringBuilder();
        for (String s :
                list) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    public static List<String> toList(int[] a){
        List<String> list = new ArrayList<>();
        for (int i :
                a) {
            list.add(String.valueOf(i));
        }
        return list;
    }
}
