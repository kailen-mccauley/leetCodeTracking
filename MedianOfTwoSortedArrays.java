class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int median = 0;
        int prevMedian = 0;
        // Use pointers i and j to find the middle element 
        // Since array are both sorted, we keep incremeting i or j until we get halfway
        // Track previous median since we will need it if we have a total length that is even
        while (i + j <= (nums1.length + nums2.length) / 2) {
            prevMedian = median;
            if (i < nums1.length && j <nums2.length) {
                median = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
            } else {
                median = i < nums1.length ? nums1[i++] : nums2[j++];
            } 
        }
    
        // Handles even length case where we average median and previous median
        if ((nums1.length + nums2.length) % 2 == 0) {
            return (double) (median + prevMedian) / 2 ;
        } else {
            return (double) median;
        }
    }
}