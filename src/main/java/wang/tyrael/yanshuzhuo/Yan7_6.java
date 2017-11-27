package wang.tyrael.yanshuzhuo;

public class Yan7_6 {
    public static void main(String[] args){
        TestOverloaded test = new TestOverloaded();
        test.print(null);
    }


}


class TestOverloaded{
    public void print(String some){
        System.out.println("print String");
    }

    public void print(Object some){
        System.out.println("print Object");
    }
}