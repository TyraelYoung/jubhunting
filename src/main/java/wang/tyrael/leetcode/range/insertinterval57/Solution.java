package wang.tyrael.leetcode.range.insertinterval57;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * TODO 代码太复杂，可以重写
 *
 * 因为每个interval不相交，
 * 需要改变的interval在newInterval之间，
 * 查起始的，应该和newInterval。left比
 * 查结束，应该和newInterval。right比
 *
 * @author: wangchao
 * 2018/4/26 0026
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        //找到第一个比new大的
        int i;
        for (i = 0; i < intervals.size(); i++) {
            Interval small = intervals.get(i);
            if (small.start > newInterval.start) {
                break;
            } else {
                result.add(small);
            }
        }
        if (i == intervals.size()) {
            //没找到
            if (i - 1 < 0) {
                //为空
                result.add(newInterval);
                return result;
            }
            Interval last = intervals.get(i - 1);
            if (last.end >= newInterval.start) {
                if(last.end < newInterval.end){
                    result.remove(i - 1);
                    int end = last.end < newInterval.end ? newInterval.end : last.end;
                    result.add(new Interval(last.start, end));
                }else{
                    //包含
                    return intervals;
                }
            } else {
                result.add(newInterval);
            }
            return result;
        }

        if (i - 1 >= 0) {
            //需要处理上一个元素的合并
            Interval last = intervals.get(i - 1);
//            if (last.end < newInterval.start){
//                //不用处理
//            }

            if (last.end >= newInterval.start) {
                if(last.end < newInterval.end){
                    //交叉、合并
                    result.remove(i - 1);
                    int end = last.end < newInterval.end ? newInterval.end : last.end;
                    newInterval = new Interval(last.start, end);
                }else{
                    //包含
                    return intervals;
                }

            }
        }

        //后续的是否需要合并？
        int j;
        for (j = i; j < intervals.size(); j++) {
            Interval big = intervals.get(j);
            if (big.end <= newInterval.end) {
                //包含在newInterval中了
                continue;
            } else {
                break;
            }
        }

        //处理可能的合并
        if (j == intervals.size()){
            result.add(newInterval);
            return result;
        }

        Interval last = intervals.get(j);
        if (last.start <= newInterval.end){
            newInterval.end = last.end;
            result.add(newInterval);
        }else{
            result.add(newInterval);
            result.add(last);
        }

        for (int k = j+1; k < intervals.size(); k++) {
            result.add(intervals.get(k));
        }

        return result;
    }
}
