import java.util.*;
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] retArray = new int[n];
        retArray[0] = 0;
        Deque<Integer> indexStack = new ArrayDeque<>();
        for (int i = 0; i < n; ++i){
            int currTemp = temperatures[i];
            while (!indexStack.isEmpty() && temperatures[indexStack.peek()] < currTemp ){
                int theDay = indexStack.pop();
                retArray[theDay] = i - theDay;
            }
            indexStack.push(i);
        }
        return retArray;
    }
}