package wang.tyrael.basic;

public class ElementCountDisjointSet {
    int[] parent;
    int[] rank;
    int[] count;

    public ElementCountDisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        count = new int[n];
    }

    public void makeSet(int x) {
        parent[x] = x;
        rank[x] = 0;
        count[x] = 1;
    }

    public void union(int x, int y) {
        if (findSet(x) == findSet(y)){
            return;
        }
        int cx = getCount(x),
                cy = getCount(y);

        setCount(x, cx+cy);
        setCount(y, cx +cy);
        link(findSet(x), findSet(y));
    }

    private void link(int set, int set1) {
        if (rank[set] > rank[set1]) {
            parent[set1] = set;

        } else if (rank[set] < rank[set1]) {
            parent[set] = set1;
        } else {
            rank[set1] += 1;
            parent[set] = set1;
        }

    }

    public int findSet(int x) {
        if (parent[x] != x) {
            int parentIndex = findSet(parent[x]);
            parent[x] = parentIndex;
        }
        return parent[x];
    }

    public int getCount(int i){
        int parent = findSet(i);
        return count[parent];
    }

    public void setCount(int i, int c){
        int parent = findSet(i);
        count[parent] = c;
    }

    public int getMaxCount(){
        int max = 0;
        for (int i = 0; i < count.length; i++) {
            if (max < count[i]){
                max = count[i];
            }
        }
        return max;
    }
}
