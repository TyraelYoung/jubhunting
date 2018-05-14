package wang.tyrael.basic.binarysearch;

import org.junit.Test;
import wang.tyrael.basic.binaryserach.IBinarySearch;
import wang.tyrael.basic.binaryserach.MaxEqual;

/**
 * @author: wangchao
 * 2018/5/14 0014
 */
public class MaxEqualTest {
    @Test
    public void test(){
        IBinarySearch binarySearch = new MaxEqual();
        int result = binarySearch.binarySearch(new int[]{1,2,2,3}, 2);
        assert result==2;
    }

    @Test
    public void test1(){
        IBinarySearch binarySearch = new MaxEqual();
        int result = binarySearch.binarySearch(new int[]{}, 2);
        assert result==-1;
    }

    @Test
    public void test2(){
        IBinarySearch binarySearch = new MaxEqual();
        int result = binarySearch.binarySearch(new int[]{1}, 2);
        assert result==-1;
    }

    @Test
    public void test5(){
        IBinarySearch binarySearch = new MaxEqual();
        int result = binarySearch.binarySearch(new int[]{3}, 2);
        assert result==-1;
    }

    @Test
    public void test3(){
        IBinarySearch binarySearch = new MaxEqual();
        int result = binarySearch.binarySearch(new int[]{1,2,3}, 2);
        assert result==1;
    }

    @Test
    public void test4(){
        IBinarySearch binarySearch = new MaxEqual();
        int result = binarySearch.binarySearch(new int[]{2,2}, 2);
        assert result==1;
    }
}
