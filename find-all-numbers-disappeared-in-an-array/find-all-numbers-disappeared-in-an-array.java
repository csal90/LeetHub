class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> map = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            map.add(nums[i]);
        }
        
        for (int i = 1; i <= nums.length; i++) {
            if (!map.contains(i)) {
                result.add(i);
            }
        }
        
        return result;
    }
}