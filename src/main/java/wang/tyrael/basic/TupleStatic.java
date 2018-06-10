package wang.tyrael.basic;

import java.util.ArrayList;
import java.util.List;

public class TupleStatic {
    public static List<Tuple> toList(Tuple[] points){
        List<Tuple> list = new ArrayList<>();
        for (Tuple p :
                points) {
            list.add(p);
        }
        return list;
    }
}
