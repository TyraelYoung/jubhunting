package wang.tyrael.leetcode;

import org.junit.Test;
import wang.tyrael.ArrayUtil;
import wang.tyrael.basic.Point;
import wang.tyrael.leetcode.erectfence587.Solution;

import java.util.List;

/**
 * @author: wangchao
 * 2018/4/17 0017
 */
public class ErectFence {
    @Test
    public void test(){
//        Input: [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
//        Output: [[1,1],[2,0],[4,2],[3,3],[2,4]]
        Solution solution = new Solution();
        List<Point> result;
        result = solution.outerTrees(ArrayUtil.parsePoint("[[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]"));
        ArrayUtil.printPoint(result);

//        Input: [[1,2],[2,2],[4,2]]
//        Output: [[1,2],[2,2],[4,2]]
        result = solution.outerTrees(ArrayUtil.parsePoint("[[1,2],[2,2],[4,2]]"));
        ArrayUtil.printPoint(result);

    }
}
