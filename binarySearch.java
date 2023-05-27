class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n;
        while (left <= right){
            int mid = left + ((right - left)/2);
            if (nums[mid] == target){
                return mid; 
            }
            if (nums[mid] < target && mid + 1 < n){
                left = mid+1;
                continue;
            }
            else if(nums[mid] > target && mid- 1 >= 0){ 
                right = mid - 1;
                continue;
            }
            else{
                return -1;
            }
        }
        return -1;
    }
}