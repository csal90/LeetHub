class Solution {
    public void sortColors(int[] nums) {
        int N = nums.length;
        for (int i = 1; i < N; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j = j - 1;
            }
            nums[j + 1] = key;
        }
    }
}
