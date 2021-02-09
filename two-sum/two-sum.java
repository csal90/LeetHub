class Solution {
    /*
        Notes: 
        
        
        Conceptual (non programmer mode) => 
            1. Look through the numbers
            2. Keep track as we go of what two numbers equal to our sum
            3. If we find one, we can return it's position in the list of numbers 
            4. Lastly, if we never find anything we can just return a dummy varaible -1
        
        Programming approach => 
        
        
    */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i , j};
                }
            }
        }
        return new int[] {-1, -1};
    }
}