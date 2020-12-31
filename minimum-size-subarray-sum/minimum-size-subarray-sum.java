class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int i = 0, j = 0, sum = 0, res = Integer.MAX_VALUE;
        
        while (i < nums.length) {
            // add the current num to sum
            sum += nums[i++];
            // keep adding it until (sum >= s) 
            while (sum >= s) {
                // we now need to calculate our current window
                res = Math.min(res, i - j);
                // remove our current sum to restablish out sum variable
                sum -= nums[j++];
            }
        }
        return (res != Integer.MAX_VALUE) ? res : 0;
    }
}
