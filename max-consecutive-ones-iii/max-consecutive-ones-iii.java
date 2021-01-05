class Solution {
    public int longestOnes(int[] A, int K) {
        // we can change a 0 to 1, K times
        int i = 0, j = 0, n = A.length;
        
        while (i < n) {
            if (A[i] == 0) K--;
            if (K < 0 && A[j++] == 0) K++;
            i++;
        }
        return i - j;
    }
}
