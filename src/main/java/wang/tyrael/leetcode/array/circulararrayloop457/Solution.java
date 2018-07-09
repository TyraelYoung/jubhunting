package wang.tyrael.leetcode.array.circulararrayloop457;

/**
 * @Auther: wangchao
 * @Date: 2018/7/9 10:39
 * @Description:
 */
public class Solution {
    int[] nums;

    public boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        this.nums = nums;
        int start = 0, fast = 0, slow = 0, preFast = 0, direction= 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            start = i;
            fast = start;
            slow = start;
            direction = nums[start] < 0? -1:1;
            while (true){

                //1步
                if (nums[fast] == 0 ) break;
                if (nums[fast] * direction < 0){
                    setFail(start, fast);
                    break;
                }
                fast = (fast + nums[fast] + nums.length) % nums.length;
                //2
                preFast = fast;
                if (nums[fast] == 0 ) break;
                if (nums[fast] * direction < 0){
                    setFail(start, fast);
                    break;
                }
                fast = (fast + nums[fast] + nums.length ) % nums.length;
                //单点循环
                if (preFast == fast){
                    setFail(start);
                    break;
                }
                slow = (slow + nums[slow] + nums.length) % nums.length;
                if (fast == slow){
                    return true;
                }
            }
        }
        return false;
    }

    void setFail(int start){
        int nextIndex = start;
        while (nums[nextIndex] != 0){
            int thisIndex = nextIndex;
            nextIndex = (thisIndex + nums[thisIndex] + nums.length) % nums.length;
            nums[thisIndex] = 0;
        }
    }

    /**
     *
     * @param start
     * @param end exclusive
     */
    void setFail(int start, int end){
        int nextIndex = start;
        while (nextIndex != end){
            int thisIndex = nextIndex;
            nextIndex = (thisIndex + nums[thisIndex] + nums.length) % nums.length;
            nums[thisIndex] = 0;
        }
    }
}
