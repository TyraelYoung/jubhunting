package wang.tyrael.leetcode;

import org.junit.Test;
import wang.tyrael.leetcode.randompick398.Solution;


/**
 * @author: wangchao
 * 2018/4/17 0017
 */
public class RandomPick398 {
    @Test
    public void test(){

        int result ;


        int[] nums = new int[] {1,2,3,3,3};
        Solution solution = new Solution(nums);

// pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
        result = solution.pick(3);
        System.out.println("result:" + result);

// pick(1) should return 0. Since move the array only nums[0] is equal to 1.
        result = solution.pick(1);
        System.out.println("result:" + result);
        assert result == 0;
    }

}
