class Solution {
    public boolean canJump(int[] nums) {
        /*
            [3,2,1,0,4]
            lastPos = 5
            (5 + 4 >= 5) => lastPost = i
            ()
        */
        int n = nums.length; 
        int lastPos = n - 1;
        
        for (int i = n - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        
        return lastPos == 0;
    }
}
