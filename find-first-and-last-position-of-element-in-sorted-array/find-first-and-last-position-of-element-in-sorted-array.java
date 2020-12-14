class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = firstOccurrence(nums, target);
        res[1] = secondOccurrence(nums, target);
        return res;
    }
    public int firstOccurrence(int[] nums, int target) {
        int low = 0, high = nums.length - 1, res = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                res = mid;
                high = mid - 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return res;
    }
    
    public int secondOccurrence(int[] nums, int target) {
        int low = 0, high = nums.length - 1, res = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                res = mid;
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return res;
    }
}
