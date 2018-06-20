package wang.tyrael.basic.binarytree;

/**
 * @Auther: wangchao
 * @Date: 2018/6/18 22:09
 * @Description:
 */
public class FenwickTree {
    //1-based
    public final int[] tree;
    //0-based
    final int[] src;


    public FenwickTree(int[] src) {
        this.src = src;
        this.tree = new int[src.length+1];
        for (int i = 1; i < tree.length; i++) {
            //十进制，i的势力范围
            int lowBit = i & -i;
            System.out.println("lowBit:" + lowBit);
            int sum = 0;
            for (int j = i - lowBit +1; j <= i; j++) sum += src[j-1];
            tree[i] = sum;
        }
    }

    public void update(int index, int value){
        int diff = value - src[index];
        src[index] = value;
        for (int i = index+1; i < tree.length; i += i& -i)  tree[i] += diff;
    }

    /**
     *
     * @param end inclusive
     * @return
     */
    public int sum(int end){
        int sum = 0;
        for (int i = end+1; i > 0; i -= i&-i) sum+= tree[i];
        return sum;
    }

    /**
     *
     * @param start inclusive
     * @param end inclusive
     * @return
     */
    public int sum(int start, int end){
        return sum(end) - sum(start-1);
    }
}
