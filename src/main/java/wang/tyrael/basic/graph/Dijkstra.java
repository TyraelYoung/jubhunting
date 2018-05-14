package wang.tyrael.basic.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Dijkstra {
    final int[][] times;
    final int K;
    int N;

    HashSet<Integer> arrived = new HashSet<>();
    public int[] distance;
    //经过的索引路径
    public List<List<Integer>> path = new ArrayList<>();

    public Dijkstra(int[][] times, int k) {
        this.times = times;
        K = k;
        N = times[0].length;
        distance = new int[N];
        for (int i = 0; i < N; i++) {
            distance[i] = times[K][i];
            path.add(new ArrayList<>());
        }
        arrived.add(K);
    }

    public void run() {
        //每次加入一个点
        for (int i = 0; i < N-1; i++) {
            int nearIndex = getNear();
            if (nearIndex == -1){
                return;
            }
            arrived.add(nearIndex);
            updateDistance(nearIndex);
        }
    }

    private void updateDistance(int bridgeIndex){
        for (int i = 0; i < N; i++) {
            if(arrived.contains(i)){
                continue;
            }
            if (distance[i] - distance[bridgeIndex]> times[bridgeIndex][i]){
                //加号越界
//                if (distance[i] > distance[bridgeIndex] + times[bridgeIndex][i]){
                distance[i] = distance[bridgeIndex] + times[bridgeIndex][i];
                List<Integer> thisPath = path.get(i);
                thisPath.add(i);
            }
        }
    }

    private int getNear(){
        int minDistance = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int j = 0; j < N; j++) {
            if (arrived.contains(j)){
                continue;
            }
            if (minDistance > distance[j]){
                minDistance = distance[j];
                minIndex = j;
            }
        }
        return minIndex;
    }
}
