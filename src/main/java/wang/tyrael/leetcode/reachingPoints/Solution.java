package wang.tyrael.leetcode.reachingPoints;

//反推
//辗转相减 -》 辗转相除
public class Solution {
    //tx = msx + nsy
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if(sx == tx && sy == ty){
            return true;
        }

        if(sx > tx || sy > ty){
            return false;
        }

        if(tx > ty){
            int n = (tx -sx) / ty;
            if(n == 0){
                return false;
            }
            int next = tx-ty * n;
            return reachingPoints(sx, sy, next, ty);
        }else if(tx < ty){
            int n = (ty -sy) / tx;
            if(n == 0){
                return false;
            }
            int next = ty-tx * n;
            return reachingPoints(sx, sy, tx, next);
        }else{
            return sx == tx && sy == ty;
        }
    }
}
