class Solution {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length; 
        
        // int[] L = new int[N];
        // int[] R = new int[N];
        int[] answer = new int[N];
        
//         L[0] = 1;
//         R[N - 1] = 1;
        
//         for (int i = 1; i < N; i++) {
//             L[i] = L[i - 1] * nums[i - 1];
//         }
        
//         for (int i = N - 2; i >= 0; i--) {
//             R[i] = R[i + 1] * nums[i + 1];
//         }
        // for (int i = 0; i < N; i++) {
        //     result[i] = L[i] * R[i];
        // }   
        
        //return result;
        
        answer[0] = 1;
        for (int i = 1; i < N; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }
        
        int R = 1;
        for (int i = N - 1; i >= 0; i--) {
            answer[i] = answer[i] * R;
            R *= nums[i];
        }
        
        return answer;
        
    }
}