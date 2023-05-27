import java.util.*;
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<>());

        for (int num: nums){
            List<List<Integer>> newSubset = new ArrayList<>();
            for (List<Integer> curr : ret){
                newSubset.add(new ArrayList<Integer>(curr){{add(num);}});
            }
            for (List<Integer> curr: newSubset){
                ret.add(curr);
            }
        }
        return ret;
                
    }
}




 // Backtrack
class Solution2 {
    int k, n;
    List<List<Integer>> retList = new ArrayList<>(); 
    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        retList.add(new ArrayList<Integer>());
        for (k = 1; k < n; ++k){
            backtrack(0,new ArrayList<>(),nums);
        }
        return retList;
    }

    private void backtrack(int index, List<Integer> curr, int[] nums){
        if(curr.size() == k){
            retList.add(curr);
            return;
        }
        for (int i = index; i < n; ++i){
            curr.add(nums[i]);
            backtrack(i+1, curr, nums);
            curr.remove(curr.size() - 1);
        }

    }
}
