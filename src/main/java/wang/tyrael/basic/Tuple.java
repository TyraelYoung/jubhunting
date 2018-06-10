package wang.tyrael.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * 二元组
 * @author: wangchao
 * 2018/4/17 0017
 */
public class Tuple<X, Y> {
    public X x;
    public Y y;

    public Tuple() {
    }

    public Tuple(X a, Y b) {
        x = a;
        y = b;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Tuple){
            Tuple b = (Tuple) obj;
            return x.equals(b.x) && y.equals(b.y);
        }else{
            return false;
        }
    }
}
