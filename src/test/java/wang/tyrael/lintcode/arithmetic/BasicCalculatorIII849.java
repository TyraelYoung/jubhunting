package wang.tyrael.lintcode.arithmetic;

import org.junit.Test;
import wang.tyrael.leetcode.TestStatic;
import wang.tyrael.lintcode.arithmetic.basiccalculatoriii849.Solution;


/**
 * @Auther: wangchao
 * @Date: 2018/7/10 15:44
 * @Description:
 */
public class BasicCalculatorIII849 {
    @Test
    public void test(){
        TestStatic.assertResult(2, new Solution().calculate("1 + 1"));
    }

    @Test
    public void test1(){
        TestStatic.assertResult(4, new Solution().calculate(" 6-4 / 2 "));
    }

    @Test
    public void test2(){
        TestStatic.assertResult(21, new Solution().calculate("2*(5+5*2)/3+(6/2+8)"));
    }

    @Test
    public void test3(){
        TestStatic.assertResult(-12, new Solution().calculate("(2+6* 3+5- (3*14/7+2)*5)+3"));
    }

    @Test
    public void test4(){
        TestStatic.assertResult(1, new Solution().calculate("1"));
    }

    @Test
    public void test5(){
        TestStatic.assertResult(4, new Solution().calculate("2 * (3-1)"));
    }

    @Test
    public void test6(){
        TestStatic.assertResult(Integer.MIN_VALUE,
                new Solution().calculate("0-2147483648"));
    }
}
