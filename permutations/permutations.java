class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generate(nums, result, new ArrayList());
        return result;
    }
    private void generate(int[] nums, List<List<Integer>> result, List<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) 
                continue;
            list.add(nums[i]);
            generate(nums, result, list);
            list.remove(list.size() - 1);
        }
    }
}