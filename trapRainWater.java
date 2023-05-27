class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int leftMaxCurr = 0;
        for (int i = 0; i < n; ++i){
            leftMaxCurr = Math.max(leftMaxCurr, height[i]);
            leftMax[i] = leftMaxCurr;
        }
        int rightMaxCurr = 0;
        for (int i = n-1; i >= 0; --i){
            rightMaxCurr = Math.max(rightMaxCurr, height[i]);
            rightMax[i] = rightMaxCurr;
        }
        int ans = 0; 
        for (int i = 0; i < n; ++i){
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
        
    }
}