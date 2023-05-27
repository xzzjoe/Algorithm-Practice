import java.util.Arrays;

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp){
            Arrays.fill(row, 1);
        }
        for (int row = 1; row < m; ++ row){
            for (int col = 1; col < n; ++ col){
                dp[row][col] = dp[row][col-1] + dp [row-1][col];
            }
        }
        return dp[m-1][n-1];
    }
}