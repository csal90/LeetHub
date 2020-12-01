class Solution {
    public int search(int[] nums, int target) {
        
        int left = 0;
        int right = nums.length - 1;
        
        // Find the roation index, when it's completed our left index will be at the smallest index
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        int start = left;
        left = 0;
        right = nums.length - 1;
        
        // set where to start the binary search
        if (target >= nums[start] && target <= nums[right]) { // sorted
            left = start;
        } else { // not sorted
            right = start;
        }
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
