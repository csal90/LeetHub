class Solution {
    public int minPathSum(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        
        int[][] dp = new int[M][N];
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                }
                else {
                    dp[i][j] = grid[i][j] + Math.min((i == 0 ? Integer.MAX_VALUE : dp[i - 1][j]),
                                                      (j == 0 ? Integer.MAX_VALUE : dp[i][j - 1]));
                }
            }
        }
        return dp[M-1][N-1];
    }
}
