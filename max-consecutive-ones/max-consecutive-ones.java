class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int i = 0, j = 0, count = 0, res = 0;
        
        while (i < nums.length) {
            if (nums[i++] == 1) {
                count += 1;
            } else {
                res = Math.max(res, count);
                count = 0;
            }
        }
        return Math.max(count, res);
    }
}
