package wang.tyrael.basic.graph;

import java.util.Arrays;

public class Floyd {
    final int[][] times;
    final int K;
    int N;

    int[][] distance;

    public Floyd(int[][] times, int k) {
        this.times = times;
        K = k;
        N = times[0].length;

        distance = new int[N][N];
        for (int i = 0; i < N; i++) {
            distance[i] = Arrays.copyOf(times[i], N);
        }
    }

    public void run(){
        for (int i = 0; i < N; i++) {
            //借助点i，从j到k的距离可以更新了
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
//                    if (distance[j][k] > distance[j][i] + distance[i][k]){
                    if (distance[j][k] -distance[j][i] > distance[i][k]){
                        distance[j][k] = distance[j][i] + distance[i][k];
                    }
                }
            }
        }
    }
}
