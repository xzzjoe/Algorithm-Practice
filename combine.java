import java.util.*;

class Solution {
    int kShare;
    int nShare;
    List<List<Integer>> retList = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        kShare = k;
        nShare = n;
        backtrack(1, new ArrayList<Integer>());
        return retList;
    
    }

    private void backtrack (int index, List<Integer> curr ){
        if (curr.size() == kShare){
            retList.add(new ArrayList<>(curr));
            return;
        }
        for (int i = index; i <= nShare; ++i){
            curr.add(i);
            backtrack(i+1, curr);
            curr.remove(curr.size() - 1);
        }

    }
}