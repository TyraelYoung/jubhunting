package wang.tyrael.basic;

/**
 * 行列号
 * @author: wangchao
 * 2018/4/28 0028
 */
public class RC {
    public static int rHeight, cWidth;

    public int r, c, value;
    public RC(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public RC(int r, int c, int value) {
        this.r = r;
        this.c = c;
        this.value = value;
    }

    public RC left(){
        if (c-1 < 0){
            return null;
        }
        return new RC(r, c-1);
    }

    public RC right(){
        if (c+1 >= cWidth){
            return null;
        }
        return new RC(r, c+1);
    }

    public RC up(){
        if (r-1 <0){
            return null;
        }
        return new RC(r-1, c);
    }

    public RC down(){
        if (r+1 >= rHeight){
            return null;
        }
        return new RC(r+1, c);
    }

    @Override
    public String toString() {
        return "(" + r + "," + c +")";
    }
}
