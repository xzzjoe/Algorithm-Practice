class Solution {
    private int[] root;
    private int[] rank; 
    private int oneCount;
    private int row;
    private int col;

    public void unionFind (char[][] grid){
        row = grid.length;
        col = grid[0].length;
        oneCount = 0;

        root = new int[row*col];
        rank = new int[row*col];

        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j ++){
                if (grid[i][j] == '1'){
                    root[i*col + j] = i*col + j;
                    rank[i*col + j] = 1;
                    ++oneCount;
                }
                else{
                    rank[i*col + j] = 0; 
                }
            }
        }
    }

    public int find (int x){
        if (x == root[x]) return x;
        return root[x] = find(root[x]);
    }

    public void union (int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY){
            if (rank[rootX] > rank[rootY]){
                root[rootY] = rootX;
                rank[rootX] ++;
            }
            else if (rank[rootX] < rank[rootY]){
                root[rootX] = rootY;
                rank[rootY] ++;
            }
            else {
                root[rootY] = rootX;
                rank[rootX] ++;
            }
            oneCount --;
        }
    }

    public int getCount(){
        return oneCount;
    }

    public int numIslands(char[][] grid) {
        unionFind(grid);
        for (int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if (grid[r][c] == '1'){
                    if (r - 1 > 0 && grid[r-1][c] == '1'){
                        union(r*col+c, (r-1)*col + c);
                        grid[r][c] = 'X';
                    }
                    if (r + 1 < row && grid[r+1][c] == '1'){
                        union(r*col+c, (r+1)*col + c);
                        grid[r][c] = 'X';
                    }
                    if(c - 1 > 0 && grid[r][c-1] == '1'){
                        union(r*col+c, r*col + c + 1);
                        grid[r][c] = 'X';
                    }
                    if (c + 1 < col && grid[r][c+1] == '1'){
                        union(r*col + c, r*col + c + 1);
                        grid[r][c] = 'X';
                    }
                }
            }
        }
        return getCount();
    }
}