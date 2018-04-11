package wang.tyrael;

public class Holder<T>{
    T[] a;
    Object[] b;

    public Holder(){
        a = (T[]) new Object[2];
        b = new Object[2];
    }

    public T[] get(){
        return (T[]) b;
    }

    public static void main(String[] args){
        Holder<String> holder = new Holder();
        String[] c = holder.get();
    }
}
