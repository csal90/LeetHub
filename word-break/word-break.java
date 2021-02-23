class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        int N = s.length();
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[N + 1];
        
        dp[0] = true;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N];
    }
}