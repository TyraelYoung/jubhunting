package wang.tyrael.leetcode;

import org.junit.Test;
import wang.tyrael.leetcode.countRepetitions.Solution;

public class CountRepetitions466 {
    @Test
    public void test(){
        Solution solution = new Solution();
        int result;
        result = solution.getMaxRepetitions("acb", 4, "ab", 2);
        assert result == 2;

//        "phqghumeaylnlfdxfircvscxggbwkfnqduxwfnfozvsrtkjprepggxrpnrvystmwcysyycqpevikeffmznimkkasvwsrenzkycxf"
//        1000000
//        "xtlsgypsfadpooefxzbcoejuvpvaboygpoeylfpbnpljvrvipyamyehwqnqrqpmxujjloovaowuxwhmsncbxcoksfzkvatxdknly"
//        100

        long start = System.currentTimeMillis();
        result = solution.getMaxRepetitions("phqghumeaylnlfdxfircvscxggbwkfnqduxwfnfozvsrtkjprepggxrpnrvystmwcysyycqpevikeffmznimkkasvwsrenzkycxf",
                1000000, "xtlsgypsfadpooefxzbcoejuvpvaboygpoeylfpbnpljvrvipyamyehwqnqrqpmxujjloovaowuxwhmsncbxcoksfzkvatxdknly",
                100);
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
//        assert result == 2;
    }
}
