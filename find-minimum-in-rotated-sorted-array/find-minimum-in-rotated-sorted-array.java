class Solution {
    public int findMin(int[] nums) {
        int N = nums.length; 
        
        if (N == 1) {
            return nums[0];
        }
        
        if (nums[0] < nums[N - 1]) {
            return nums[0];
        }
        
        int low = 0;
        int high = N - 1;
        
        while (low < high) {
            int pivot = low + (high - low) / 2;
            
            if (nums[pivot] > nums[pivot + 1]) {
                return nums[pivot + 1];
            }
            
            else if (nums[pivot] < nums[pivot - 1]) {
                return nums[pivot];
            }
            
            else if (nums[low] > nums[pivot]) {
                high = pivot - 1;
            } else {
                low = pivot + 1;
            }
        }
        
        return -1;
    }
}