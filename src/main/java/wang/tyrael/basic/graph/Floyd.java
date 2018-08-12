package wang.tyrael.basic.graph;

import java.util.Arrays;

public class Floyd {
    final int[][] times;
    int N;
    int[][] distance;

    public Floyd(int[][] times) {
        this.times = times;
        N = times[0].length;
        distance = new int[N][N];
        for (int i = 0; i < N; i++)  distance[i] = Arrays.copyOf(times[i], N);
    }

    public void run(){
        for (int bridge = 0; bridge < N; bridge++) {
            //借助点i，从j到k的距离可以更新了
            for (int start = 0; start < N; start++) {
                for (int end = 0; end < N; end++) {
//                    if (distance[j][k] > distance[j][i] + distance[i][k]){
                    if (distance[start][end] -distance[start][bridge] > distance[bridge][end]){
                        distance[start][end] = distance[start][bridge] + distance[bridge][end];
                    }
                }
            }
        }
    }
}
