class Solution {
    int [] rank;
    int [] root;
    int count;

    private void init(int n){
        rank = new int[n];
        root = new int[n];
        count = 0;

        for (int i = 0; i < n; i++){
            root[i] = i;
            rank[i] = 1;
            count ++;
        }
    }

    private int find (int x){
        if(root[x] == x){
            return x;
        }
        return root[x] = find(root[x]);
    }

    private void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY){
            if (rank[rootX] > rank[rootY]){
                root[rootY] = rootX;
                rank[rootX]++;
            }
            else if (rank[rootY] > rank[rootX]){
                root[rootX] = rootY;
                rank[rootY] ++;
            }
            else{
                root[rootY] = rootX;
                rank[rootX]++;
            }
            count --;
        }
    }
    
    private int getCount(){
        return this.count;
    }
    


    public int countComponents(int n, int[][] edges) {
        init(n);
        // int lenEdges = edges.length;

        for (int[] edge : edges){
            union(edge[0], edge[1]);
        }
        int ret = getCount();
        return ret;
    }
}