import java.lang.Math;
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for(int pile : piles){
            right = Math.max(right, pile);
        }
        while (left <= right){
            int mid = left + ((right - left)/2);
            if (eatable(piles, mid, h)){
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return right;

    }

    private boolean eatable(int[] piles,int speed, int h){
        int hours = 0;
        for (int pile: piles){
            hours += pile/speed;
        }
        return hours<=h ;
    }
}