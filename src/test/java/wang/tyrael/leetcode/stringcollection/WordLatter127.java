package wang.tyrael.leetcode.stringcollection;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import wang.tyrael.leetcode.TestStatic;
import wang.tyrael.leetcode.TestTask;
import wang.tyrael.leetcode.stringcollection.wordlatter127.Solution;

/**
 * @Auther: wangchao
 * @Date: 2018/6/29 14:47
 * @Description:
 */
public class WordLatter127 {
    @Test
    public void test(){
        TestStatic.assertResult(5, new Solution().ladderLength(
                "hit",
                "cog",
                JSON.parseArray("[\"hot\",\"dot\",\"dog\",\"lot\",\"log\",\"cog\"]", String.class)
        ));
    }

    @Test
    public void test1(){
        TestStatic.assertResult(0, new Solution().ladderLength(
                "hit",
                "cog",
                JSON.parseArray("[\"hot\",\"dot\",\"dog\",\"lot\",\"log\"]", String.class)
        ));
    }
}
