class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        List<List<Integer>> result = new ArrayList<>();
        generate(nums, k, 0, new ArrayList(), result);
        
        return result;
        
    }
    private void generate(List<Integer> nums, int k, int start, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == k) {
            result.add(new ArrayList(list));
        }
        
        for (int i = start; i < nums.size(); i++) {
            list.add(nums.get(i));
            generate(nums, k, i + 1, list, result);
            list.remove(list.size() - 1);
        }
        
    }
}