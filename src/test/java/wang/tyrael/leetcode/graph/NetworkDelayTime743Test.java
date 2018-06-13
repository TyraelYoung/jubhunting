package wang.tyrael.leetcode.graph;

import org.junit.Test;
import wang.tyrael.ArrayUtil;
import wang.tyrael.leetcode.graph.NetworkDelayTime743.Solution;


public class NetworkDelayTime743Test {
    @Test
    public void test(){
        Solution solution = new Solution();
        int result = solution.networkDelayTime(
                ArrayUtil.parse2D("[[2,1,1],[2,3,1],[3,4,1]]"), 4,2);
        assert result == 2;
    }
    @Test
    public void test1(){
        Solution solution = new Solution();
        int result = solution.networkDelayTime(
                ArrayUtil.parse2D("[[1,2,1]]"), 2,1);
        assert result == 1;
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        int result = solution.networkDelayTime(
                ArrayUtil.parse2D("[]"), 2,1);
        assert result == -1;
    }

    @Test
    public void test3(){
        Solution solution = new Solution();
        int result = solution.networkDelayTime(
                ArrayUtil.parse2D("[[1,2,1]]"), 2,2);
        assert result == -1;
    }
}
