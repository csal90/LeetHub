class Solution {
    public int rob(int[] nums) {
        int N = nums.length;
        
        // nums is empty, return 0
        if (N == 0) {
          return 0;  
        }
        
        // nums has 1 element, return it 
        if (N == 1) {
            return nums[0];
        }
        
        // nums has it least 2 elements, dp[i] = Max Money up until i
        int[] dp = new int[N];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        // iterate over the nums starting from 2 
        // apply competing subproblems 
        for (int i = 2; i < nums.length; i++) {
​
            // first competing subproblem
            int include = nums[i] + dp[i - 2];
            int dontInclude = dp[i - 1];
            dp[i] = Math.max(include, dontInclude);
        }
        
        return dp[N-1];
    }
}
