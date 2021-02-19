class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*
                    [4,5,1,8,2]
            L=>   [1,4,20,20,160]
                   ^
            R=>   [80,16,16,2,1]
                               ^
                               
            Result=> [L] * [R]
            
        */
        int N = nums.length;
        
        int[] result = new int[N];
        
        int[] L = new int[N];
        L[0] = 1;
        
        int[] R = new int[N];
        R[N - 1] = 1;
        
        // compute product of everything to the left of nums[i]
        for (int i = 1; i < N; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }
        
        // compute product of everything to the right of nums[i]
        for (int i = N - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }
        
        // store the result to result array
        for (int i = 0; i < N; i++) {
            result[i] = L[i] * R[i];
        }
        
        return result;
    }
}