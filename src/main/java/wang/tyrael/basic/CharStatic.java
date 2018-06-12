package wang.tyrael.basic;

/**
 * @author: wangchao
 * 2018/6/12 0012
 */
public class CharStatic {
    public boolean isDigit(char c){
       return c <= '9' && c >= '0';
    }

    public boolean isUpperCase(char c){
        return c <= 'Z' && c >= 'A';
    }

    public boolean isLowerChase(char c){
        return c <= 'z' && c >= 'a';
    }
}
