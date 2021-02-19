class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int N = nums.length;
        
        for (int i = 0; i < N; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) 
                continue;
            int low = i + 1;
            int high = N - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while (low < high && nums[low] == nums[low + 1]) 
                        low++;
                    while (low < high && nums[high] == nums[high - 1]) 
                        high--;
                    low++;
                    high--;
                } else if (sum < 0) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return result;
    }
}