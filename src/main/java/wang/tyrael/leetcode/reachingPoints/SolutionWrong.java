package wang.tyrael.leetcode.reachingPoints;

public class SolutionWrong {
    //tx = msx + nsy
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        return findMN(sx, sy, tx) && findMN(sx, sy, ty);
    }

    public boolean findMN(int sx, int sy, int sum){
        int mMax = sum / sx;
        int n;
        for (int i = 0; i <= mMax; i++) {
            if((sum - sx *i) % sy == 0){
                return true;
            }
        }
        return false;
    }
}
