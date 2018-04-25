package wang.tyrael.leetcode.recurringdecimal166;

import java.util.HashMap;
import java.util.Map;

/**
 * 模拟长除法处理
 */
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        boolean flagNegtive = (numerator > 0) ^ (denominator > 0);
        long nL = Math.abs((long)numerator);
        long dL = Math.abs((long)denominator);
        long zL = nL / dL;
        long y = nL % dL;
        if (y == 0) {
            if (flagNegtive){
                return Long.toString(-zL);
            }else{
                return Long.toString(zL);
            }

        }

        StringBuilder sb = new StringBuilder();
        Map<Long, Integer> yMap = new HashMap<>();
        yMap.put(y, -1);
        int index = 0;
        int found = 0;
        boolean flagDefinite = false;
        while(true){
            //考虑越界
            y *= 10;
            long z1 = y / dL;
            y = y % dL;
            if(y == 0){
                sb.append(z1);
                flagDefinite = true;
                break;
            }


            found = yMap.getOrDefault(y, -2);
            sb.append(z1);
            if (found > -2){
                //重复了！
                break;
            }
            yMap.put(y, index);

            index++;
        }

        if(!flagDefinite){
            sb.insert(found +1, '(');
            sb.append(')');
        }

        sb.insert(0, '.');
        sb.insert(0, zL);

        if(flagNegtive){
            sb.insert(0, '-');
        }

        return sb.toString();
    }
}
