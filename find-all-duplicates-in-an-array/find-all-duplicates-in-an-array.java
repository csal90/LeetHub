class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == 2) {
                res.add(entry.getKey());
            }
        }
        return res;
    }
}
