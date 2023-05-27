import java.util.*;
class Solution {
    public int jump(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        map.put(0, 0);
        for (int i = 0; i < n; ++ i){
            int currJump = map.get(i);
            int maxJump = nums[i];
            for (int j = 0; j <= maxJump; ++j){
                if (i+j >= n) break;
                if(map.containsKey(j+i)){
                    int prevMin = map.get(j+i);
                    if (currJump + 1 < prevMin ){
                        map.replace(j+i, currJump+1);
                    }
                }
                else{
                    map.put(i+j, currJump+1);
                }
            }
        }
        return map.get(n-1);
    }
}