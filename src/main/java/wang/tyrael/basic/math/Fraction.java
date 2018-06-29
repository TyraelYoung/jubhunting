package wang.tyrael.basic.math;

import com.google.common.math.LongMath;
import wang.tyrael.basic.Tuple;

public class Fraction extends Tuple<Long, Long> {
    public static final Fraction ZERO = new Fraction(0L, 1L);

    public Fraction() {
    }

    public Fraction(Long a, Long b) {
        super(a, b);
    }

    public Fraction multiply(int a){
        long x = this.x * a;
        return new Fraction(x, y).reduce();
    }

    public Fraction minus(Fraction subtrahend){
        long x = this.x * subtrahend.y - this.y * subtrahend.x;
        long y = this.y * subtrahend.y;
        return new Fraction(x,y).reduce();
    }

    public Fraction negative(){
        return new Fraction(this.x, -y);
    }

    public Fraction reduce(){
        if (x.equals(0)){
            //标准化无穷
            y = y > 0? 1L:-1L;
            return this;
        }
        //注意越界
        long gcd = LongMath.gcd(Math.abs(x), Math.abs(y));
        x = x / gcd;
        y = y / gcd;
        normalizeSign();
        return this;
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
