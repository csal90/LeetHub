class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        
        int max = -1, left = 0, current = 0;
        
        for (int right = 0; right < nums.length; right++) {
            current += nums[right];
            while (current > total - x && left <= right) {
                current -= nums[left];
                left += 1;
            }
            if (current == total - x) {
                max = Math.max(max, right - left + 1);
            }
        }
        
        return max != -1 ? nums.length - max : -1;
    }
}
