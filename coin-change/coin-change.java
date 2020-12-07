class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                // check if the current coin is <= amount which is (i)
                if (coins[j] <= i) {
                    // find the minimum
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1); // i cents - current coin we are at
                }
            }
        }
        return (dp[amount] > amount) ? -1 : dp[amount];
    }
}
​
​
