class Solution {
    public int maxProduct(int[] nums) {
        /* 
            Idea:
                - Keep track of the min at all times
                - Keep track of the max at all times
                - Keep track of overall max 
                
                minSoFar = nums[0]
                maxSoFar = nums[0]
                overAllMax = nums[0]
                
                for (int i = 1; i < n; i++) {
                    minSoFar = Math.min(nums[i], Math.min(nums[i] * minSoFar))
                    maxSoFar = Math.max(nums[i], Math.max(nums[i] * maxSoFar))
                    overAllMax = Math.max(minSoFar, maxSoFar)
                }
                
                return overAllMax
            
                [2,3,-2,4]
                minSoFar = 2, 2, -2
                MaxSoFar = 6
                overAll  = 6
                
                minSoFar = min {2, min{3 * 2, 3}} => 2
                maxSoFar = max {2, max{3 * 2, 3}} => 6
                
                minSoFar = min {2, min{-2 * 2, -2}} => -2
                minSoFar = max {2, max{3 * 2, 3}} => 6
                
                
        */
        int minSoFar = nums[0];
        int maxSoFar = nums[0];
        int overAllMax = maxSoFar;
                
        for (int i = 1; i < nums.length; i++) {
            int temp = maxSoFar * nums[i];
            maxSoFar = Math.max(nums[i], Math.max(nums[i] * maxSoFar, nums[i] * minSoFar));
            minSoFar = Math.min(temp, Math.min(nums[i] * minSoFar, nums[i]));
            overAllMax = Math.max(overAllMax, maxSoFar);
        }
                
        return overAllMax;
    }
}