class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }
    public void backtrack(List<List<Integer>> res, List<Integer> tmp, int[] nums, int start) {
        // first add the tmp array to the result array 
        res.add(new ArrayList<>(tmp));
        for (int i = start; i < nums.length; i++) {
            // skip duplicate values 
            if (i > start && nums[i] == nums[i - 1]) continue;
            // add i to our current combination 
            tmp.add(nums[i]);
            // keep adding the rest of the combinations 
            backtrack(res, tmp, nums, i + 1);
            // backtrack
            tmp.remove(tmp.size() - 1);
        }
    }
}
