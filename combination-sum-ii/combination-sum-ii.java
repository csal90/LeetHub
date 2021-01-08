class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(int[] candidates, int start, 
                           int target, List<Integer> temp, 
                           List<List<Integer>> result) {
        // base cases 
        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList(temp));
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            temp.add(candidates[i]);
            backtrack(candidates, i + 1, target - candidates[i], temp, result);
            temp.remove(temp.size() - 1);   
        }
    }
}
