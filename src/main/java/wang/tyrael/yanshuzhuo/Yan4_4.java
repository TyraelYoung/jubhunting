package wang.tyrael.yanshuzhuo;

public class Yan4_4 {
    public static void main(String[] args){
        int n=7;
        n<<=3;
        System.out.println(Integer.toBinaryString(n));
        n = n&n + 1|n + 2^n + 3;
        System.out.println(n);
        System.out.println(Integer.toBinaryString(n));
        n>>=2;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(n);
    }
}
