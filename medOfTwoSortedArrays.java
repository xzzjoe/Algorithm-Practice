import java.lang.*;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2){
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0; 
        int high = len1;

        while (low <= high){
            int partition1 = (low + high)/2;
            int partition2 = (len1 + len2 + 1)/2 - partition1;

            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE: nums1[partition1 - 1];
            int minRight1 = (partition1 == len1) ? Integer.MAX_VALUE : nums1[partition1];
            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == len2) ? Integer.MAX_VALUE: nums2[partition2];

            if ((maxLeft1 <= minRight2) && (maxLeft2 <= minRight1)){
                if ( (len1 + len2) % 2 == 0){
                    return ((double) (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)))/2;
                } 
                else{
                    return (double) Math.max(maxLeft1, maxLeft2);
                }
            }
            else if (maxLeft2 > minRight1){
                low = partition1 + 1;
            }
            else{
                high = partition1 - 1;
            }
            
        }
        throw new IllegalArgumentException();
    }
}