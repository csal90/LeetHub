class Solution {
    public int lengthOfLIS(int[] nums) {
        // Base cases 
        if (nums.length == 1) {
            return 1;
        }
        
        // Fill the dp array with (1) at each position we have at list a sequence of 1
        int max = 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        // Iterate over the array (start from 1)
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) { // iterate all the elements before i
                if (nums[j] < nums[i]) { // only then it's an increasing subsequence 
                    dp[i] = Math.max(dp[i], dp[j] + 1); // it's possible we have computed a longer LIS, this is why we take the max of the previous solution, OR dp[j] + 1 indicating we should include thise element 
                }
                max = Math.max(max, dp[i]);
            }
        }
        
        return max;
    }
}