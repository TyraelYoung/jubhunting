package wang.tyrael.leetcode.range.insertinterval57;

import com.alibaba.fastjson.JSON;
import wang.tyrael.basic.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangchao
 * 2018/4/26 0026
 */
public class IntervalStatic {
    public static List<Interval> parseForList(String s) {
        List<String> ls = JSON.parseArray(s, String.class);
        List<Interval> result = new ArrayList<>();
        for (int i = 0; i < ls.size(); i++) {
            String item = ls.get(i);
            List<Integer> lo = JSON.parseArray(item, Integer.class);
            result.add(new Interval(lo.get(0), lo.get(1)));
        }
        return result;
    }

    public static void printList(List<Interval> intervals){
        for (Interval i : intervals) {
            System.out.print("" + i + ",");
        }
    }
}
