package wang.tyrael.basic.string;

import org.junit.Test;

public class KMPTest {
    @Test
    public void test(){
        KMP kmp = new KMP("ababaca");
        int result = kmp.match("bacbababaabcbab");
        assert result == -1;
    }

    @Test
    public void test1(){
        KMP kmp = new KMP("acb");
        int result = kmp.match("bacbababaabcbab");
        assert result == 1;
    }

    @Test
    public void test2(){
        KMP kmp = new KMP("bab");
        int result = kmp.match("bacbababaabcbab");
        assert result == 3;
    }

    @Test
    public void test3(){
        KMP kmp = new KMP("");
        int result = kmp.match("");
        assert result == 0;
    }
}
