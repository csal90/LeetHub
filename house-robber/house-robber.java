class Solution {
    public int rob(int[] nums) {
        /*
            DP approach: 
            
            1) Determine if its a dp problem
            2) Solve the recurrance relation 
                - optimized recursion 
            3) Memoize the pre. sub problems 
            
            dp [                         X] N - 1
                        
            Base case:
            dp[0] => nums[0]
            dp[1] => Max {nums[0], nums[1]}
            
            for i <- 2 to n 
                dp[i] = Max { nums[i] + dp[i - 2], dp[i - 1]}

            return dp[n-1]
        
        */
        if (nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        
        return dp[nums.length - 1];
    }
}