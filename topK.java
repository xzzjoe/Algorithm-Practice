import java.util.*;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == k){
            return nums;
        }
        HashMap <Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        PriorityQueue <Integer> heap = new PriorityQueue<>((n1,n2) -> map.get(n2) - map.get(n1));
        for (int n : map.keySet()){
            heap.add(n);
        }
        int arrSize = k; 
        // > heap.size() ? k : heap.size(); 
        int [] retArr = new int[arrSize];
        for (int i = 0; i < arrSize; ++i){
            retArr[i] = heap.poll();
        }
        return retArr;
    }
}