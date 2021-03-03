class Solution {
    public int missingNumber(int[] nums) {
        /*
            Take the sum of the array
            Then calculate the expected sum by doing n * (n - 1) / 2
            Return the actual sum - exprected to find the missing number 
        */
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        int n = nums.length + 1;
        int expectedSum = n * (n - 1) / 2;
        return expectedSum - actualSum;
    }
}