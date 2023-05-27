import java.util.Arrays;

class Solution {
    int[] rank;
    int[] root;
    int count;
    int timeAcq;

    private void init(int n){
        rank = new int[n];
        root = new int[n];
        count = n;
        timeAcq = -1;
        for (int i = 0; i < n; i++){
            rank[i] = 1;
            root[i] = i;
        }
    }

    private int find(int i){
        if (root[i] == i){
            return i;
        }
        return root[i] = find(root[i]);
    }

    private void union(int x, int y, int time){
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
            this.timeAcq = this.timeAcq < time ? time : this.timeAcq;
        }
    }

    private int getCount(){
        return this.count;
    }

    public int earliestAcq(int[][] logs, int n) {
        init(n);
        Arrays.sort(logs, (a,b) -> a[0]-b[0]);
        for (int[] log : logs){
            union(log[1], log[2], log[0]); 
        }
        int numGroups = getCount();
        if (numGroups > 1){
            return -1;
        }
        else{
            return this.timeAcq;
        }
    }
}