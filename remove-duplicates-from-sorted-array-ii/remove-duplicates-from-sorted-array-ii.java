class Solution {
    public int removeDuplicates(int[] nums) {
        int allowed = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[allowed - 2]) {
                nums[allowed++] = nums[i];
            }
        }
        return allowed;
    }
}
