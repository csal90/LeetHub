class Solution {
    public int uniquePaths(int m, int n) {
        /*
            1. The robot can only move either DOWN or RIGHT at each point in time
            2. The answer is found at M-1, N-1
            3. How many unique paths?
            
            We can solve this problem using DP approach 
            Iterate over each row and col, and compute each step we can make 
                - dp[i-1][j]
                - dp[i][j-1]
            return dp[n-1][m-1] because that's where out answer will be stored 
            
        */
        int row = m;
        int col = n;
        
        int[][] dp = new int[row][col];
        
        // we need to kick start our DP
        for (int[] arr: dp) {
            Arrays.fill(arr, 1);
        }
        
        // start at position (since we kickstarted above) 
        // and computer the two moves we can make in dp[i][j]
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
