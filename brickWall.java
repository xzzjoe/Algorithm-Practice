import java.util.*;
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int numWalls = wall.size();
        List<List<Integer>> sumWalls = new ArrayList<>();
        for (List<Integer> curr: wall){
            sumWalls.add(prefixSum(curr));
        }
        int maxCount = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (List<Integer> curr: sumWalls){
            for (int i = 0; i < curr.size() -1; i++){
                int currEdge = curr.get(i);
                int count = map.getOrDefault(currEdge,0);
                count ++;
                maxCount = Math.max(maxCount, count);
                map.put(currEdge, count);
            }
        }
        return numWalls - maxCount;
        
    }

    public List<Integer> prefixSum (List<Integer> wall){
        List<Integer> retArr = new ArrayList<>();
        int runningSum = 0;
        for (Integer i : wall){
            runningSum += i;
            retArr.add(runningSum);
        }
        return retArr;
    }
}