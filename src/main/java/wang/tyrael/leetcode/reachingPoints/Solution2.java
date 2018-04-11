package wang.tyrael.leetcode.reachingPoints;

public class Solution2 {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if(sx > tx || sy > ty){
            return false;
        }else if(sx == tx && sy == ty){
            return true;
        }
        return reachingPoints(sx+sy, sy, tx, ty) || reachingPoints(sx, sx+sy, tx, ty);
    }
}
