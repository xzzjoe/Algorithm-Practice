import java.util.Arrays;
class UnionFind{
    public int[] rank;
    public int[] root;
    public UnionFind (int size){
        rank = new int[size];
        root = new int[size];
        for (int i = 0; i < size; ++i){
            rank[i] = 0;
            root[i] = i; 
        }
    }

    public int find (int x){
        if (root[x] == x){
            return x;
        }
        return root[x] = find(root[x]);
    }

    public boolean union (int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY){
            return false;
        }
        if (rank[rootX] > rank[rootY]){
            root[rootY] = rootX;
        }
        else if (rank[rootY] > rank[rootX]){
            root[rootX] = rootY;
        }
        else{
            rank[rootX] ++;
            root[rootY] = rootX;
        }
        return true;
    }


}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int numPoints = points.length;
        UnionFind uf = new UnionFind(numPoints);
        int numEdges = (numPoints*(numPoints-1))/2;
        int[][] edges = new int[numEdges][];
        int edgeCount = 0;
        for (int i = 0; i < numPoints; ++i){
            for (int j = i+1; j < numPoints; ++ j){
                int currDist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1]- points[j][1]);
                edges[edgeCount] = new int[] {currDist,i, j};
                edgeCount ++;
            }
        }
        Arrays.sort(edges,(a,b) ->  a[0] - b[0]);
        int addCount = 0;
        int totCost = 0;
        for (int[] edge : edges){
            if (addCount == numPoints - 1){
                break;
            }
            if (uf.union(edge[1], edge[2])){
                ++addCount;
                totCost += edge[0]; 
            }

        }
        return totCost;
    }
}