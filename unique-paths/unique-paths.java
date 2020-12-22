class Solution {
    /*
        [[1,1,1,1,1,1],
         [1,2,3,4,5,6],
         [1,3,6,10,15,21],
         [1,4,10,20,35,56],
         [1,5,15,35,70,126]]
    */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        for (int[] arr: dp) {
            Arrays.fill(arr, 1);
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        System.out.print(dp);
        return dp[m - 1][n - 1];
    }
}
