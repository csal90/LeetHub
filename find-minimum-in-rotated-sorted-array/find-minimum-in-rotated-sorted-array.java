class Solution {
    public int findMin(int[] nums) {
        /*
            - check if our nums is already sorted 
            
            - check if length of nums is 1
            
            - Binary search 
                - mid 
                - nums[mid] > nums[mid + 1]
                    return nums[mid + 1] <-- that is our min value 
                
                - nums[mid - 1] > nums[mid]
                    return nums[mid] <-- that has to be our min value 
                    
                - update our pointers 
                if (nums[mid] > nums[0])
                    low = mid + 1
                else 
                    high = mid -1
        */
        int low = 0;
        int high = nums.length - 1;
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        if (nums[0] < nums[high]) {
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