import java.util.*;
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int n = nums.length;
        int runningSum = 0;
        for(int i = 0; i < n; i++){
            runningSum += nums[i];
            runningSum %= k;
            Integer prev = map.get(runningSum);
            if (prev != null){
                if (i - prev > 1) return true;
            }
        }
        return false;

    }
}