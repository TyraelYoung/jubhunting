package wang.tyrael.leetcode;

import org.junit.Test;
import wang.tyrael.leetcode.subsets78.Solution;
import wang.tyrael.ArrayUtil;


import java.util.List;

/**
 * @author: wangchao
 */
public class Subsets78 {
    @Test
    public void test(){
        Solution solution = new Solution();
        List<List<Integer>> result = solution.subsets(ArrayUtil.parse("[1,2,3]"));
        for (List<Integer> item :
                result) {
            System.out.println("a:");
            ArrayUtil.printInt(item);
        }
    }
}
