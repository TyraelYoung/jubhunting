package wang.tyrael.yanshuzhuo;

public class Yan4_6 {
    public static void main(String[] args){
        int x= 5;
        int y = 3;
        x = x + (x++) + (++x) + y;
        System.out.println(x);

        test();
        test1();
    }

    public static void test(){
        int x= 5;
        int y = 3;
        x = x + (x++) ;
        System.out.println(x);
    }

    public static void test1(){
        int x= 5;
        int y = 3;
        x = (x++) + (++x) ;
        System.out.println(x);
    }
}
