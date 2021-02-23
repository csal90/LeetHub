class Solution {
    public int findMin(int[] nums) {
                /*
            - we need to check if array is already sorted
            if (nums[0] < nums[N-1]) return nums[0]
            
            - we need to check if the array length is 1
            if (N == 1) return nums[0]
            
            - Modified binary search:
            
            1) checking nums[mid] < nums[mid + 1] 
                return nums[mid + 1]
            
            2) checking nums[mid - 1] < nums[mid]
                return nums[mid]
                
            Updating our pointers. 
            
            if (nums[mid] < nums[0]) 
                high = mid - 1
            else
                low = mid + 1            
        */
        
        int low = 0;
        int high = nums.length - 1;
        
        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[mid] > nums[0]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}