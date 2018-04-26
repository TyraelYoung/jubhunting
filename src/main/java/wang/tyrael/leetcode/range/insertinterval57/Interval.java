package wang.tyrael.leetcode.range.insertinterval57;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * @author: wangchao
 * 2018/4/26 0026
 */
public class Interval {
    int start;
    int end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int s, int e) {
        start = s;
        end = e;
    }

    public Interval(String s){
        List<Integer> lo = JSON.parseArray(s, Integer.class);
        start = lo.get(0);
        end = lo.get(1);
    }

    @Override
    public String toString() {
        return "(" + start + "," +end + ")";
    }
}
