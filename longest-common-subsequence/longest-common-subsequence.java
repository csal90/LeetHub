class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int R = text1.length();
        int C = text2.length(); 
        
        int[][] dp = new int[R + 1][C + 1];
        
        for (int i = R - 1; i >= 0; i--) {
            for (int j = C - 1; j >= 0; j--) {
                // if the characters are the same
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else { // otherwise they must be difference
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        
        return dp[0][0];
    }
}