import java.util.Arrays;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // int[][] dp = new int[n][n];
        // Arrays.fill(dp, -1);
        int maxVal = 0;
        for (int i = 0; i < n; ++i){
            int buy = prices[i];
            for (int j = i; j < n; ++j){
                int sell = prices[j];
                int profit = sell - buy;
                // dp[i][j] = profit;
                maxVal = Math.max(maxVal, profit);
            }
        }
        return maxVal;
    }
}