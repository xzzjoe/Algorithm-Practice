import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    PriorityQueue<int[]> q;
    public int[][] kClosest(int[][] points, int k) {
        this.q = new PriorityQueue<>(new sortByDist());
        for (int[] point: points){
            this.q.offer(point);
        }
        ArrayList<int[]> retList = new ArrayList<>();
        int count = 0;
        while(count < k){
            retList.add(this.q.poll());
            count++;
        }
        int[][] retArr = new int[k][2]; 
        retArr = retList.toArray(retArr);
        return retArr;

    }
    class sortByDist implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            double distanceA = (Math.pow(a[0], 2) + Math.pow(a[1],2));
            double distanceB = (Math.pow(b[0], 2) + Math.pow(b[1],2));
            if(distanceA - distanceB > 0){
                return 1;
            }
            else if ( distanceA - distanceB < 0){
                return -1;
            }
            else{
                return 0;
            }
        }
    }
}