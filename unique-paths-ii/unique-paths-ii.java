class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /*
            - we start at the top left corner of m x n grid
            - we can only move DOWN or RIGHT at any cell 
            - we are trying to reach the grid[m-1][n-1]
            - How many unique paths are there 
            - *** An obstacle is considered a (1) and space is (0)
            
            - down move => grid[i][j-1]
            - right move => grid[i-1][j]
            
            [[0,0,0],
             [0,1,0],
             [0,0,0]]
        */
        int M = obstacleGrid.length;
        int N = obstacleGrid[0].length;
        
        int[][] dp = new int[M][N];
        
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        
        // Kickstart first row and first column
        for (int i = 0; i < M; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
                break;
            } else {
                dp[i][0] = 1;
            }
        }
        
        for (int j = 0; j < N; j++) {
            if (obstacleGrid[0][j] == 1) {
                dp[0][j] = 0;
                break;
            } else {
                dp[0][j] = 1;
            }
        }
        
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        
        return dp[M-1][N-1];
​
    }
}
