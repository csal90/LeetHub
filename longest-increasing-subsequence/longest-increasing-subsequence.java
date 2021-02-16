class Solution {
    public int lengthOfLIS(int[] nums) {
        /*
                Recurrance relation idea:
                
                    base case: once we extend past the nums[] array => return 
                    
                    2 recursive calls:
                        - (1) => Take the current number (aka add onto our increasing subsequence)
                        
                        - (2) => Do not take the current number 
                        
                        Lastly, take the max ( 1 , 2) of our two recursive calls 
                        and see which gives you a longer subsequence 
                        
                    Time: O(2^n) Space: O(n^2)
                    
                
                Dynamic Programming: 
                
                    
        */
        
        int[] dp = new int[nums.length];
        int max = 1;
        
        for (int nIndx = 0; nIndx < nums.length; nIndx++) {
            dp[nIndx] = 1;
            for (int dpIndx = 0; dpIndx < nIndx; dpIndx++) {
                if (nums[dpIndx] < nums[nIndx]) {
                    dp[nIndx] = Math.max(dp[nIndx], dp[dpIndx] + 1);
                    max = Math.max(max, dp[nIndx]);
                }
            }
        }
        return max;
    }
}