class Solution {
    public static int rob(int[] nums) {
        int N = nums.length;
        if (N == 1) {
            return nums[0];
        }
        if (N == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int [] p1 = Arrays.copyOfRange(nums, 1, N);
        int [] p2 = Arrays.copyOfRange(nums, 0, N - 1);
        return Math.max(robHelper(p1), robHelper(p2));
    }
    
    public static int robHelper(int[] nums) {
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
