class Solution {
    public int removeDuplicates(int[] nums) {
        int retLen = 0;
        int n = nums.length;
        int duplicate_num = -101;

        for (int i = 0, j = 0; i < n; i ++){
            if (nums[i] != duplicate_num){
                nums[j] = nums[i];
                duplicate_num = nums[i];
                j++;
                retLen ++;
            }
            else{
                continue;
            }
        }
        return retLen;
    }
}