class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        //int[] dp = new int[n + 1];
        
        //dp[0] = 1;
        //dp[1] = 1;
        
        int first = 1;
        int second = 1;
        int curr = 0;
        
        for (int i = 2; i <= n; i++) {
            //dp[i] = dp[i - 2] + dp[i - 1];
            curr = first + second;
            first = second;
            second = curr;
        }
        
        return second;
    }
}