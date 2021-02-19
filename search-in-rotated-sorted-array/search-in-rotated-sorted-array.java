class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] == target) {
                return pivot;
            }
            // check if the RHS is increasing
            if (nums[pivot] >= nums[low]) {
                if (target >= nums[low] && target < nums[pivot]) {
                    high = pivot - 1;
                } else {
                    low = pivot + 1;
                }
            } else {
                if (target <= nums[high] && target > nums[pivot]) {
                    low = pivot + 1;
                } else {
                    high = pivot - 1;
                }
            }
        }
        return -1;
    }
}