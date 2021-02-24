class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        
        int max = 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1); // every number is considered it's own subsequence 
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) { // theres a number we can use in or LIS
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(dp[i], max);
            }
        }
        
        return max;
        
    }
}