class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] candidates, int start, int target, List<Integer> list, List<List<Integer>> result) {
        if (target < 0) return;
        
        if (target == 0) {
            result.add(new ArrayList(list)); // we've reached the bottom of our rec. tree
        }
        
        for (int i = start; i < candidates.length; i++) {
            // add the current candidate element to our temp list
            list.add(candidates[i]);
            backtrack(candidates, i, target - candidates[i], list, result);
            list.remove(list.size() - 1); // we cant do any further, backtrack
        }
        
    }
​
}
