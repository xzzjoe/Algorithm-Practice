class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int [] ans = {0,0};
        for (int i = 0; i < n; i ++){
            int num_one = nums[i];
            for (int j = i; j < n; j++){
                int num_two = nums[j];
                if (num_one + num_two == target && i != j){
                    ans[0] = i;
                    ans[1] = j;
                    break;
                }
            }
        }
        return ans;
    }
}