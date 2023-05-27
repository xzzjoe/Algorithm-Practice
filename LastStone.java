import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    PriorityQueue<Integer> q;
    public int lastStoneWeight(int[] stones) {
        this.q = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones){
            this.q.add(stone);
        }
        while(this.q.size() > 1){
            int stoneOne = this.q.poll();
            int stoneTwo = this.q.poll();
            int diff = Math.abs(stoneOne - stoneTwo);
            if (diff > 0){
                this.q.add(diff);
            }
        }
        if (this.q.isEmpty()) return 0;
        else return this.q.poll();
    }
}