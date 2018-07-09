package wang.tyrael.leetcode.matrix.bricksfalling803;

public class Solution {

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int[] result = new int[hits.length];
        //逆转时间
        for (int i = 0; i < hits.length; i++) {
            if (grid[hits[i][0]][hits[i][1]] == 1) grid[hits[i][0]][hits[i][1]] = 0;
            else hits[i][0] = -1;
        }
        //初始化并查集
        int row = grid.length;
        int column = grid[0].length;

        DisjointCountSet dcs = new DisjointCountSet(row * column +1);
        //创建一个特殊的。
        int topId = row*column;
        dcs.makeSet(topId);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 0) continue;

                int id = i * column + j;
                dcs.makeSet(id);
                if (i == 0){
                    dcs.union(id, topId);
                }else{
                    if (grid[i-1][j] == 1) dcs.union(id, (i-1)*column +j);
                    if (j > 0 && grid[i][j-1] == 1) dcs.union(id, i * column + j-1);
                }

            }
        }

        //从后往前补
        for (int i = hits.length-1; i >= 0; i--) {
            if (hits[i][0] == -1){
                result[i] = 0;
                continue;
            }
            int preCount = dcs.getCount(topId);

            int rowIndex = hits[i][0], columnIndex = hits[i][1];
            grid[rowIndex][columnIndex] = 1;
            int id = rowIndex * column + columnIndex;
            dcs.makeSet(id);
            if (rowIndex == 0){
                dcs.union(id, topId);
            }
            //四个方向union
            if (rowIndex >= 1 && grid[rowIndex-1][columnIndex] == 1){
                int upId = (rowIndex -1) * column + columnIndex;
                dcs.union(id, upId);
            }
            if (columnIndex >= 1 && grid[rowIndex][columnIndex-1] == 1){
                int leftId = rowIndex * column + columnIndex -1;
                dcs.union(id, leftId);
            }
            if (rowIndex < row-1 && grid[rowIndex+1][columnIndex] == 1){
                int downId = (rowIndex+1) * column + columnIndex;
                dcs.union(id, downId);
            }
            if (columnIndex < column-1 && grid[rowIndex][columnIndex +1] == 1){
                int rightId = rowIndex * column + columnIndex +1;
                dcs.union(id, rightId);
            }

            int count = dcs.getCount(topId);
            if (count -preCount > 0) result[i] = count - preCount -1;
            else result[i] = 0;
        }

        return result;
    }
}

 class DisjointCountSet {
    int[] parent;
    int[] rank;
    //每个集合元素个数
    int[] count;
    //集合总数
    int countSet;

    public DisjointCountSet(int n) {
        parent = new int[n];
        rank = new int[n];
        count = new int[n];
    }

    /**
     * 要求本来没有。
     * @param x
     */
    public void makeSet(int x) {
        if (parent[x] != 0) return;
        parent[x] = x;
        rank[x] = 0;
        count[x] = 1;
        countSet++;
    }

    public void union(int x, int y) {
        if (findSet(x) == findSet(y)){
            return;
        }
        countSet--;
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

    public int getCountSet(){
        return countSet;
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
