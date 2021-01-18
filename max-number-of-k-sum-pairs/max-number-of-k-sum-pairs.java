class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int delta = k - nums[i];
            if (map.getOrDefault(delta, 0) > 0) {
                map.put(delta, map.get(delta) - 1);
                count += 1;
            } else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        return count;
    }
}
