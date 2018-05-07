package wang.tyrael.leetcode.reachingPoints;

//反推
public class SolutionOverflow {
    //tx = msx + nsy
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if(sx > tx || sy > ty){
            return false;
        }

        if(tx > ty){
            int next = tx-ty;
            return reachingPoints(sx, sy, next, ty);
        }else if(tx < ty){
            int next = ty-tx;
            return reachingPoints(sx, sy, tx, next);
        }else{
            return sx == tx && sy == ty;
        }
    }
}
