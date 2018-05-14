package wang.tyrael.basic.graph;

public class GraphStatic {
    public static int[][] convert(int[][] edges, int n){
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j){
//                    graph[i][j] = 0;
                }else{
                    graph[i][j] = Integer.MAX_VALUE;
                }

            }
        }
        for (int[] edge :
                edges) {
            graph[edge[0]][edge[1]] = edge[2];
            graph[edge[1]][edge[0]] = edge[2];
        }
        return graph;
    }

    public static int[][] convert1Based(int[][] edges, int n){
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j){
//                    graph[i][j] = 0;
                }else{
                    graph[i][j] = Integer.MAX_VALUE;
                }

            }
        }
        for (int[] edge :
                edges) {
            graph[edge[0]-1][edge[1]-1] = edge[2];
            graph[edge[1]-1][edge[0]-1] = edge[2];
        }
        return graph;
    }

    public static int[][] convert1BasedDirected(int[][] edges, int n){
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j){
//                    graph[i][j] = 0;
                }else{
                    graph[i][j] = Integer.MAX_VALUE;
                }

            }
        }
        for (int[] edge :
                edges) {
            graph[edge[0]-1][edge[1]-1] = edge[2];
        }
        return graph;
    }
}
