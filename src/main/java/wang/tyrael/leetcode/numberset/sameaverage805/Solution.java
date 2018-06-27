package wang.tyrael.leetcode.numberset.sameaverage805;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 双向树搜索，中间匹配。
 * 本来需要匹配平均值，需要精确计算，比较麻烦。
 * 把整体平均值标准化为0，就方便很多。
 *
 * @Auther: wangchao
 * @Date: 2018/6/27 12:00
 * @Description:
 */
public class Solution {
    static MidResult add(MidResult old, int x){
        return new MidResult(old.sum + x, old.count+1);
    }

    static class MidResult{
        int sum;
        int count;

        public MidResult(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }

        @Override
        public int hashCode() {
            return ("" + sum + "," + count).hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            MidResult midResult = (MidResult) obj;
            return this.sum == midResult.sum && this.count == midResult.sum;
        }
    }

    Set midSet = new HashSet();

    int[] A;

    int[] average0;
    int leftEnd = 0;

    public boolean splitArraySameAverage(int[] A) {
        if (A == null || A.length <= 1) return false;

        normalize();

        this.A = A;
        leftEnd = (A.length-1)/2;

        processLeftHalf();
        return processRightHalf();
    }

    void normalize(){
        average0 = Arrays.copyOf(A, A.length);
    }

    /**
     * 处理数组左半部分的数据，将结果存到map
     */
    void processLeftHalf(){
        nextlevel(new MidResult(A[0], 1), 1);
        nextlevel(new MidResult(0, 0), 1);
    }

    /**
     * 处理右半部分数据，并查找，尝试匹配数据
     */
    boolean processRightHalf(){
        return nextlevelRight(new MidResult(A[leftEnd+1], 1), leftEnd+2);
    }

    /**
     *
     * @param parent
     * @param nextlevel 这里就是索引
     */
    private void nextlevel(MidResult parent, int nextlevel){
        if (nextlevel > leftEnd){
            midSet.add(parent);
            return;
        }
        nextlevel(add(parent, A[nextlevel]), nextlevel+1);
        nextlevel(parent, nextlevel+1);
    }

    private boolean nextlevelRight(MidResult parent, int nextlevel){
        if (nextlevel == A.length){
            //平均数是否相等？

            return midSet.contains(parent);
        }
        return nextlevelRight(add(parent, A[nextlevel]), nextlevel+1)
                || nextlevelRight(parent, nextlevel+1);
    }
}
