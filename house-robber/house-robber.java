class Solution {
    public int rob(int[] nums) {
        int prevMax = 0;
        int currMax = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = currMax;
            currMax = Math.max(currMax, nums[i] + prevMax);
            prevMax = temp;
        }
        return currMax;
    }
}
