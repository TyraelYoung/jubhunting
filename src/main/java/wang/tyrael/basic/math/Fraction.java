package wang.tyrael.basic.math;

import wang.tyrael.basic.Tuple;

import static wang.tyrael.basic.math.MathStatic.gcdPositive;

public class Fraction extends Tuple<Long, Long> {
    public Fraction() {
    }

    public Fraction(Long a, Long b) {
        super(a, b);
    }

    public void reduce(){
        if (x.equals(0)){
            //标准化无穷
            y = y > 0? 1L:-1L;
            return;
        }
        //注意越界
        long gcd = gcdPositive(Math.abs(x), Math.abs(y));
        x = x / gcd;
        y = y / gcd;
        normalizeSign();
        return ;
    }

    /**
     * 符号标准化
     */
    public void normalizeSign(){
        int sign;
        if (x == 0){
            sign = y>=0?1:-1;
        }else{
            sign = (x > 0 & y> 0) | (x<0 & y<0) ? 1:-1;
        }
        x = Math.abs(x);
        y = sign * Math.abs(y);
    }
}
