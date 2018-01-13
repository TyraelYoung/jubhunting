package wang.tyrael;

import java.util.List;

public class MathUtil {
    public static int max(int[] candidate){
        int max = Integer.MIN_VALUE;
        for(int i=0; i< candidate.length; i++){
            if(max < candidate[i]){
                max = candidate[i];
            }
        }
        return max;
    }

    public static int max(List<Integer> candidate){
        int max = Integer.MIN_VALUE;
        for(int i=0; i< candidate.size(); i++){
            if(max < candidate.get(i)){
                max = candidate.get(i);
            }
        }
        return max;
    }
}
