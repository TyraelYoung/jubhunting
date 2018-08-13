package wang.tyrael.basic.binarytree;

import org.junit.Test;
import wang.tyrael.ArrayUtil;

/**
 * @Auther: wangchao
 * @Date: 2018/6/18 22:24
 * @Description:
 */
public class FenwickTreeTest {
    @Test
    public void test(){
        FenwickTree fenwickTree = new FenwickTree(new int[]{1,2,3});
        ArrayUtil.printArray(fenwickTree.tree);
        assert 1 == fenwickTree.sum(0);
        assert 3 == fenwickTree.sum(1);
        assert 6 == fenwickTree.sum(2);
        fenwickTree.update(1, 3);
        System.out.println();
        ArrayUtil.printArray(fenwickTree.tree);
        assert 7 == fenwickTree.sum(2);

        System.out.println();
        fenwickTree = new FenwickTree(new int[]{1,2,3,4,5,6,7,8});
    }
}
