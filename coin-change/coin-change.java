class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); 
        
        dp[0] = 0; // fewest amount of coins to make 0 cents. 
        
        for (int i = 1; i <= amount; i++) {
            // simulate taking coins (ith cents)
            for (int j = 0; j < coins.length; j++) {
                // if our coin is smaller than or equal to i, 
                // we should try to take that coin!
                
                /* 
                    dp[i - coins[j]] is saying the following:
                    
                    1 + => we take the coin
                    what is are new amount? i - coins[j]
                    [i - coins[j]] is already a subproblem we have solved!
                    
                    a.k.a lookup the best amount we can use to makeup the amount 
                */ 
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        
        // its possible we never modifed our amount, if we have we return if not -1
        return dp[amount] > amount ? - 1 : dp[amount];
    }
}