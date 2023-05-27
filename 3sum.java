import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        for (int i = 0; nums[i] <= 0 && i < nums.length; i ++){
            if (i == 0 || nums[i] != nums[i-1]){
                twoSum(nums, i, res);
            }
        }
        return res;
    }

    public void twoSum(int[] nums, int i, List<List<Integer>> res) {
        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            if (sum == 0){
                res.add(Arrays.asList(nums[i],nums[left], nums[right]));
                while (left < right && nums[left] == nums[left -1]){
                    left ++;
                }
            }
            else if (sum < 0) {
                left ++; 
            }
            else {
                right --;
            }
        }
    }
}