package wang.tyrael.basic.string;

import org.junit.Test;

public class KMPTest {
    @Test
    public void test(){
        KMP kmp = new KMP("bacbababaabcbab", "ababaca");
        int result = kmp.match();
        assert result == -1;
    }

    @Test
    public void test1(){
        KMP kmp = new KMP("bacbababaabcbab", "acb");
        int result = kmp.match();
        assert result == 1;
    }

    @Test
    public void test2(){
        KMP kmp = new KMP("bacbababaabcbab", "bab");
        int result = kmp.match();
        assert result == 3;
    }
}
