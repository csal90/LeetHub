class Solution {
    public int lengthOfLIS(int[] nums) {
        /*  
            [10,9,2,5,3,7,101,18]
        */
        
        if (nums.length == 1) {
            return 1;
        }
 
        int max = 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}