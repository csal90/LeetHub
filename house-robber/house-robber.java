class Solution {
    public int rob(int[] nums) {
        /*
            nums = [1,2,3,1]
            nums = [2,7,9,3,1]

            dp[nums + 1]
            dp[0] = nums[0]
            dp[1] = math.max(dp[0], dp[1])
            
           1, 2, 4, 4
            
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1])
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