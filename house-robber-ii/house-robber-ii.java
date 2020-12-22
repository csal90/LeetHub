class Solution {
    public static int rob(int[] nums) {
        int N = nums.length;
        
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return nums[0];
        }
        if (N == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int [] a = Arrays.copyOfRange(nums, 1, N);
        int [] b = Arrays.copyOfRange(nums, 0, N - 1);
        return Math.max(robMax(a), robMax(b));
    }
    
    public static int robMax(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < N; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[N - 1];
    }
    
}