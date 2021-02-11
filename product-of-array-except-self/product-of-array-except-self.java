class Solution {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length; 
        
        int[] L = new int[N];
        int[] R = new int[N];
        int[] answer = new int[N];
        
        // product of elements to left 
        L[0] = 1;
        for (int i = 1; i < N; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }
        
        // product of elements to right 
        R[N - 1] = 1;
        for (int i = N - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }
        
        // combine results into answer array 
        for (int i = 0; i < N; i++) {
            answer[i] = L[i] * R[i];
        }
        
        return answer;
    }
}