class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int start;
        int end;
        int mid;
        int indexR = rotateIndex(nums);
        if (indexR != -1){
            if (target > nums[n - 1]){
                start = 0;
                end = indexR;
            }
            else {
                start = indexR;
                end = n - 1;
            }
        }
        else {
            start = 0;
            end = nums.length - 1;
        }
        while (start <= end){
            mid = start + (end - start)/2;
            if (nums[mid] == target){
                return mid;
            }
            else if (nums[mid] < target){
                start = mid + 1;
            }
            else{
                end = mid - 1; 
            }
        }
        return -1; 
    }

    public static int rotateIndex(int[] nums){
        int startNum = nums[0];
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;

        while (start <= end){
            mid = start + (end - start)/2;
            if (nums[mid] == startNum){
                // if mid value is same as start value
                if (nums.length == 1){
                    return -1;
                }
                else{
                    if (nums[0] > nums[1]){
                        return 1; 
                    }
                    else {
                        return -1;
                    }
                }

            }
            else if (nums[mid] > startNum){
                start = mid + 1;
            }
            else if (nums[mid] < startNum){
                if (nums[mid - 1] < nums[mid]){
                    end = mid - 1;
                }
                else{
                    return mid;
                }
            }
        }
        return -1;
    }
}