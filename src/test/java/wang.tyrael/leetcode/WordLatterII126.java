package wang.tyrael.leetcode;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import wang.tyrael.ArrayUtil;
import wang.tyrael.leetcode.wordlatterII126.Solution;

import java.util.List;

public class WordLatterII126 {
    @Test
    public void test(){
        Solution s = new Solution();
        String begin,end;
        List<String> list;
        List<List<String>> result;
        begin = "hit";
        end = "cog";
        list = JSON.parseArray("[\"hot\",\"dot\",\"dog\",\"lot\",\"log\",\"cog\"]", String.class);
        result = s.findLadders(begin, end, list);
        s.printGraph();
        print(result);
    }

    @Test
    public void test1(){
        Solution s = new Solution();
        String begin,end;
        List<String> list;
        List<List<String>> result;
        begin = "hit";
        end = "dot";
        list = JSON.parseArray("[\"hot\",\"dot\",\"dog\",\"lot\",\"log\",\"cog\"]", String.class);
        result = s.findLadders(begin, end, list);
        s.printGraph();
        print(result);
    }

    @Test
    public void testIsNear(){
        Solution s = new Solution();
        boolean result = s.isNear("hot", "dot");
        assert result;
    }

    void print(List<List<String>> result){
        for (List<String> item:
             result) {
            System.out.println();
            ArrayUtil.print(item);
        }
    }
}
