class Solution {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        
        int[] L = new int[N];
        int[] R = new int[N];
        int[] res = new int[N];
        
        L[0] = 1;
        R[N-1] = 1;
        
        // Add product of everything to the left of (i)
        for (int i = 1; i < N; i++) {
            L[i] = nums[i-1] * L[i-1];
        }
        
        // Add product of everything to the right of (i)
        for (int i = N-2; i >= 0; i--) {
            R[i] = nums[i+1] * R[i+1];
        }
        
        // Move L and R to the res array
        for (int i = 0; i < N; i++) {
            res[i] = L[i] * R[i];
        }
        
        return res;
    }
}
