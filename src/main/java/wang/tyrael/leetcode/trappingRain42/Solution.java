package wang.tyrael.leetcode.trappingRain42;

public class Solution {
    public int trap(int[] height) {
        if(height.length < 2){
            return 0;
        }

        int leftIndex = -1;
        boolean findTop = true;
        int sum = 0;
        //找到第一个高点
        int top = findTop(0, height);
        if(top == -1){
            return sum;
        }
        leftIndex = top;
        findTop = false;
//游标
        int i = 0;
        i = top;

        while (true) {
            if(findTop){
                //上坡中
                top = findNextTop(i, height[leftIndex],height);
                if(top == -1){
                    return sum;
                }
                sum += sum(leftIndex, top, height);
                leftIndex = top;
                findTop = false;
                i = top;
            }else{
                //下坡中
                int low = findLow(i, height);
                if(low == -1){
                    return sum;
                }
                findTop = true;
                i = low;
            }
        }
    }

    /**
     *
     * @param start 下坡的点
     * @param leftHeight
     * @param height
     * @return
     */
    public int findNextTop(int start, int leftHeight, int[] height){
        if(start == height.length -1){
            return -1;
        }
        int nextTop = start;
        for (int i = start +1; i < height.length; i++) {
            if(height[i] >= height[nextTop]){
                nextTop = i;
            }
            if(height[i] >= leftHeight){
                return i;
            }
        }
        return nextTop;
    }

    /**
     *
     * @param left 索引
     * @param right
     * @param height
     * @return
     */
    public int sum(int left, int right, int[] height){
        if(left > right){
            throw new RuntimeException("左高度的索引必须小于右高度");
        }
        int lessTop = Math.min(height[left], height[right]);
        int sum = 0;
        for (int i = left; i < right; i++) {
            if(height[i] < lessTop){
                sum += lessTop - height[i];
            }
        }
        return sum;
    }

    /**
     * 上坡的最高点
     * @param start
     * @param height
     * @return
     */
    public int findTop(int start, int[] height){
        if(start == height.length -1){
            return -1;
        }
        for (int i = start +1; i < height.length; i++) {
            if(height[i] < height[i-1]){
                return i-1;
            }
        }
        return height.length-1;
    }

    /**
     * 下坡的最低点
     * @param start
     * @param height
     * @return
     */
    public int findLow(int start, int[] height){
        if(start == height.length -1){
            return -1;
        }
        for (int i = start +1; i < height.length; i++) {
            if(height[i] > height[i-1]){
                return i-1;
            }
        }
        return height.length-1;
    }

}
