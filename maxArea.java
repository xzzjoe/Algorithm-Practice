class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left != right){
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, minHeight * width);
            int maxHeight = Math.max(height[left], height[right]);
            if (height[left] == maxHeight){
                right --;
            }
            else{
                left ++;
            }
        }
        return maxArea;
    }
}