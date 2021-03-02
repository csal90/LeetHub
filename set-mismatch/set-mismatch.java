class Solution {
    public int[] findErrorNums(int[] nums) {
        int duplicate = 0, missing = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                duplicate = num;
            }
            set.add(num);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                missing = i;
            }
        }
        return new int[]{duplicate, missing};
    }
}