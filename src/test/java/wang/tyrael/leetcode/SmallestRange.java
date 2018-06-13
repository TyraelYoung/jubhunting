package wang.tyrael.leetcode;

import org.junit.Test;
import wang.tyrael.ArrayUtil;
import wang.tyrael.leetcode.smallestrange632.Solution;

/**
 * @author: wangchao
 * 2018/4/25 0025
 */
public class SmallestRange {
    @Test
    public void test(){
        Solution solution = new Solution();
        int[] result = solution.smallestRange(ArrayUtil.parse2DInteger(
                "[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]"));
        ArrayUtil.printArray(result);
        assert result[0] == 20;
        assert result[1] == 24;
    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        int[] result = solution.smallestRange(ArrayUtil.parse2DInteger(
                "    [" +
                        "[-89,1,69,89,90,98]," +
                        "[-43,-36,-24,-14,49,61,66,69]," +
                        "[73,94,94,96]," +
                        "[11,13,76,79,90]," +
                        "[-40,-20,1,9,12,12,14]," +
                        "[-91,-31,0,21,25,26,28,29,29,30]," +
                        "[23,88,89]," +
                        "[31,42,42,57]," +
                        "[-2,6,11,12,12,13,15]," +
                        "[-3,25,34,36,39]," +
                        "[-7,3,29,29,31,32,33]," +
                        "[4,11,14,15,15,18,19]," +
                        "[-34,9,12,19,19,19,19,20]," +
                        "[-26,4,47,53,64,64,64,64,64,65]," +
                        "[-51,-25,36,38,50,54]," +
                        "[17,25,38,38,38,38,40]," +
                        "[-30,12,15,19,19,20,22]," +
                        "[-14,-13,-10,68,69,69,72,74,75]," +
                        "[-39,42,70,70,70,71,72,72,73]," +
                        "[-67,-34,6,26,28,28,28,28,29,30,31]]\n"));
        ArrayUtil.printArray(result);
        assert result[0] == 13;
        assert result[1] == 73;
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        int[] result = solution.smallestRange(ArrayUtil.parse2DInteger(
                "    [" +
                        "[73,94,94,96]," +
                        "[11,13,76,79,90]," +
                        "[13]]"));
        ArrayUtil.printArray(result);
        assert result[0] == 13;
        assert result[1] == 73;
    }
}
