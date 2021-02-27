class Solution {
    public int maximalSquare(char[][] matrix) {
        /*
                [["1","0","1","0","0"],
                 ["1","0","1","1","1"],
                 ["1","1","1","1","1"],
                 ["1","0","0","1","0"]]
                 
                 [["0","1"],
                  ["1","0"]]
        */
        int M = matrix.length; 
        int N = matrix[0].length; 
        
        int[][] dp = new int[M + 1][N + 1];
        int maximal = 0;
        
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), 
                                                     dp[i - 1][j - 1]);
                    maximal = Math.max(dp[i][j], maximal);
                }
            }
        }
        
        return maximal * maximal;
    }
}