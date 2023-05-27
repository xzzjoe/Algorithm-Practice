class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0){
            return new int[]{-1,-1};
        }
        int leftBound = findLeftBound(nums, target);
        int RightBound = findRightBound(nums, target);
        int[] retArray = new int[2];
        retArray[0] = leftBound;
        retArray[1] = RightBound;
        return retArray;
        
    }

    public static int findLeftBound(int[] nums, int target){
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int mid = 0;

        while (start <= end){
            mid = start + (end - start)/2;
            if (nums[mid] == target){
                if (mid == 0){
                    return mid;
                }
                else if (nums[mid - 1] == target){
                    end = mid - 1;
                }
                else{
                    return mid;
                }
            }
            else if (nums[mid] < target){
                start = mid + 1; 
            }
            else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static int findRightBound(int[] nums, int target){
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int mid = 0;

        while (start <= end){
            mid = start + (end - start)/2;
            if (nums[mid] == target){
                if (mid == n - 1){
                    return mid;
                }
                else if (nums[mid + 1] == target){
                    start = mid + 1;
                }
                else{
                    return mid;
                }
            }
            else if (nums[mid] < target){
                start = mid + 1; 
            }
            else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
