class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        
        // already sorted?
        if (nums[0] <= nums[high]) {
            return nums[0];
        }
        
            
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // mid + 1 is smallest
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            
            // mid element has to be the smallest 
            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            
            if (nums[low] > nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return -1;
    }
}