class Solution {
    public int maxProduct(int[] nums) {
        /*
            We need to keep track of the following:
            - Zeros
            - Negatives
            - Positives 
            
            maxSoFar = nums[0]
            minSoFar = nums[0]
            maxOverall = maxSoFar
            
            for i <- 1 to n
                maxSoFar = Max { nums[i] * maxSoFar, nums[i] * minSoFar, nums[i] }
                minSoFar = Min { nums[i] * maxSoFar, nums[i] * minSoFar, nums[i] }
                maxOverall = Max { maxSoFar, maxOverall }
            
            return maxOverall
        */
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int maxOverall = maxSoFar;
        
        for (int i = 1; i < nums.length; i++) {
            int tempMax = nums[i] * maxSoFar;
            maxSoFar = Math.max(nums[i], Math.max(nums[i] * maxSoFar, nums[i] * minSoFar));
            minSoFar = Math.min(tempMax, Math.min(nums[i] * minSoFar, nums[i]));
            maxOverall = Math.max(maxOverall, maxSoFar);
        }
        
        return maxOverall;
    }
}