class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] retArray = new int[n];
        retArray[0] = 1;
        for (int i = 1; i < n; ++i){
            retArray[i] = retArray[i-1] * nums[i-1];
        }
        int backpass = 1;
        for (int j = n - 1; j >= 0; --j){
            retArray[j] *= backpass;
            backpass *= nums[j];
        }
        return retArray;       
    }
}