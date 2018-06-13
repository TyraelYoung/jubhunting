package wang.tyrael.leetcode;

import org.junit.Test;
import wang.tyrael.ArrayUtil;
import wang.tyrael.leetcode.substring30.Solution;

import java.util.List;

public class Substring30 {
    @Test
    public void test(){
        Solution solution = new Solution();
        String[] input;
        List<Integer> result;
        input = ArrayUtil.parseString("[\"foo\", \"bar\"]");
        result = solution.findSubstring("barfoothefoobarman", input);
        assert result.get(0) == 0;
        assert result.get(1) == 9;
    }
}
