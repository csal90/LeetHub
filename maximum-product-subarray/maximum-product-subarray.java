class Solution {
    public int maxProduct(int[] nums) {
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int overAllMax = maxSoFar; 
        
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i] * maxSoFar;
            maxSoFar = Math.max(nums[i], Math.max(nums[i] * maxSoFar, nums[i] * minSoFar));
            minSoFar = Math.min(temp, Math.min(nums[i] * minSoFar, nums[i]));
            overAllMax = Math.max(overAllMax, maxSoFar);
        }
        
        return overAllMax;
    }
}