package wang.tyrael.leetcode;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import wang.tyrael.leetcode.wordbreak139.Solution;

public class WordBreak139 {
    @Test
    public void test(){
        Solution solution = new Solution();
        boolean result = solution.wordBreak("leetcode",
                JSON.parseArray("[\"leet\", \"code\"]", String.class));
        assert result;
    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        boolean result = solution.wordBreak("applepenapple",
                JSON.parseArray("[\"apple\", \"pen\"]", String.class));
        assert result;
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        boolean result = solution.wordBreak("catsandog",
                JSON.parseArray("[\"cats\", \"dog\", \"sand\", \"and\", \"cat\"]", String.class));
        assert !result;
    }

    @Test
    public void test3(){
        Solution solution = new Solution();
        boolean result = solution.wordBreak("",
                JSON.parseArray("[]", String.class));
        assert !result;
    }
}
