import javax.swing.JTree.DynamicUtilTreeNode;

class Solution {
    private int targetColor;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.targetColor = color;
        if (image[sr][sc] != color) dfs(image, sr, sc, image[sr][sc]);
        return image;
        
    }

    public void dfs (int[][] image, int row, int col, int original){
        if (image[row][col] == original){
            image[row][col] = targetColor;
            if (row + 1 < image.length ) dfs(image, row+1, col, original);
            if (row - 1 >= 0 ) dfs(image, row-1, col, original);
            if (col + 1 < image[0].length) dfs(image, row, col+1, original);
            if (col -1 >= 0) dfs(image, row, col-1, original);
        }
    }
}