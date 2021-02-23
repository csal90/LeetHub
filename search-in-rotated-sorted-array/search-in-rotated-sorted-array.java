class Solution {
    public int search(int[] nums, int target) {
        /*
            - check if value is mid. return
            
            - check if value is in low -> mid
                LHS is increasing 
                - if value is nums[low] <= target < nums[mid]
                        high = mid - 1
                  else 
                        low = mid + 1
                
            - check if value is in mid -> high
                RHS is increasing 
                if value is nums[mid] <= target < nums[high]
                      low = mid + 1
                  else 
                      high = mid - 1
                        
            - Return -1 (we never found the target)
        */
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // LHS is increasing
            if (nums[mid] >= nums[low]) {
                // check if target is inside range 
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            
            // RHS is increasing
            else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        
        return -1;
    }
}