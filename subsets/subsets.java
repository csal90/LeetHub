class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }
    public void backtrack(List<List<Integer>> res, List<Integer> tmp, int[] nums, int start) {
        res.add(new ArrayList<>(tmp));
        for (int i = start; i < nums.length; i++) {
            // add i to the current combination
            tmp.add(nums[i]);
            // use next integers to complete the combination
            backtrack(res, tmp, nums, i + 1);
            // backtrack!
            tmp.remove(tmp.size() - 1);
        }
    }
}
