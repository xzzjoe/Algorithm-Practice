import java.util.*;
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //O(n) time and O(1) space
        int n = nums.length;
        for (int i = 0; i < n; i ++){
            int val = Math.abs(nums[i]);
            nums[val-1] = -Math.abs(nums[val-1]);
        }
        List<Integer> retArr = new ArrayList<>();
        for (int i = 0; i < n; i++){
            if(nums[i] > 0){
                retArr.add(i+1);
            }
        }
        return retArr;
    }
}