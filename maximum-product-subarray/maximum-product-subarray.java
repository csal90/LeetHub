class Solution {
    public int maxProduct(int[] nums) {

        if (nums.length == 0) return 0;

        int currMax = nums[0];
        int currMin = nums[0];
        int result = currMax;
        
        for (int i = 1; i < nums.length; i++) {
            
            int tmpMax = Math.max(nums[i], Math.max(currMin * nums[i], currMax * nums[i]));            
            currMin = Math.min(nums[i], Math.min(currMin * nums[i], currMax * nums[i]));
            
            currMax = tmpMax;
            result = Math.max(result, currMax);

        }
        
        return result;
    }
}