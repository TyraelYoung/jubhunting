package wang.tyrael.leetcode.specialbinary761;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
//    String s;

    public String makeLargestSpecial(String S) {
//        this.s = S;
        return divideAndSort(S);
    }

    String processChild(String s) {
        System.out.println("processChild:" + s);
        if (s.length() <= 2) {
            return s;
        }
        //去掉头尾的1，0
        String child = s.substring(1, s.length()-1);
        String sorted = divideAndSort(child);
        return "1" + sorted + "0";
    }

    String divideAndSort(String s) {
        System.out.println("divideAndSort:" + s);
        List<String> d = new ArrayList<>();
        int start = 0;
        int end = nextSpecial(start, s);
        while (end != -1) {
            String fragment = processChild(s.substring(start, end + 1));
            d.add(fragment);

            start = end + 1;
            end = nextSpecial(start, s);
        }
        //d中至少有一个
        //比较本层
        //小的排前面？
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a = o1 + o2;
                String b = o2 + o1;
                return a.compareTo(b);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = d.size() - 1; i >= 0; i--) {
            sb.append(d.get(i));
        }
        return sb.toString();

    }

    private int nextSpecial(int start, String s) {
        if (start > s.length() - 1) {
            return -1;
        }
        if (s.charAt(start) == '0') {
            throw new RuntimeException();
        }
        int count1 = 0;
        int count0 = 0;
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count1++;
            } else {
                count0++;
            }
            if (count1 == count0) {
                return i;
            }
        }
        throw new RuntimeException();
    }
//
//    int next(int start, char needle){
//        for (int i = start; i < s.length(); i++) {
//            if (s.charAt(i) == needle){
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    void make(){
//        for (int i = 0; i < s.length(); i++) {
//            if(s.charAt(i) == 0){
//                continue;
//            }
//            int aStart = i;
//            int aEnd = nextSpecial(aStart);
//            if(aEnd + 1 == s.length() || s.charAt(aEnd + 1) == '0'){
//                return;
//            }
//            int bStart = aEnd + 1;
//            int bEnd = nextSpecial(bStart);
//
//            //是否需要交换？
//
//        }
//    }
//
//    /**
//     *
//     * @param start
//     * @return end
//     */
//    int nextSpecial(int start){
//        if(start > s.length()-1){
//            return -1;
//        }
//        if (s.charAt(start) == '0'){
//            throw new RuntimeException();
//        }
//        int count1 = 0;
//        int count0 = 0;
//        for (int i = start; i < s.length(); i++) {
//            if (s.charAt(i) == '1'){
//                count1 ++;
//            }else{
//                count0++;
//            }
//            if (count1 == count0){
//                return i;
//            }
//        }
//        throw new RuntimeException();
//    }


}
