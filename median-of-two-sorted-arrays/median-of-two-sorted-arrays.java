class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Double result = null;
        int[] tmp = mergeArrays(nums1, nums2);
        int lo = 0, hi = 0, middle = 0;
    
        if (tmp.length == 2) {
            double sum = tmp[0] + tmp[1];
            result = (sum / 2);
            return result;
        }
        
        if (tmp.length % 2 != 0) { 
            lo = 0;
            hi = tmp.length - 1;
            middle = lo + (hi - lo) / 2;
            result = (double) tmp[middle];
            return result;
        } 
        else if (tmp.length % 2 == 0) {
            lo = 0;
            hi = tmp.length - 1;
            middle = lo + (hi - lo) / 2;
            int sum = tmp[middle] + tmp[middle + 1];
            result = (sum == 0) ? 0 : (double) sum / 2;
            return result;
        }
​
        return -1;
    }
​
    
    public int[] mergeArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return nums2;
        }
        
        if (nums2.length == 0) {
            return nums1;
        }
        
        int[] res = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
