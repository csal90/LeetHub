class Solution {
    public int[] sortedSquares(int[] nums) {
        int N = nums.length;
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            res[i] = nums[i] * nums[i];
        }
        Arrays.sort(res);
        return res;
    }
}