package wang.tyrael.basic;

/**
 * @author: wangchao
 */
public class DisjointSet {
    int[] parent;
    int[] rank;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
    }

    public void makeSet(int x){
        parent[x] = x;
        rank[x] = 0;
    }

    public void union(int x, int y){
        link(findSet(x), findSet(y));
    }

    private void link(int set, int set1) {
        if (rank[set] > rank[set1]){
            parent[set1] = set;

        }else if (rank[set] < rank[set1]){
            parent[set] = set1;
        }else{
            rank[set1] += 1;
            parent[set] = set1;
        }
    }

    public int findSet(int x){
        if (parent[x] != x){
            parent[x] = findSet(parent[x]);
        }
        return parent[x];
    }
}
