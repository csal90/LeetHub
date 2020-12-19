class Solution {
    public boolean increasingTriplet(int[] nums) {
        /*
            - keep track of the first two numbers in increasing order
            - find the last number which will be bigger than the first two numbers
            
        */
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= first) {
                first = nums[i];
            } else if (nums[i] <= second) {
                second = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}
