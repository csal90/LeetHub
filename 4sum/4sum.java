class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            while (i > 0 && i < nums.length - 1 && nums[i-1] == nums[i]) i++; 
            int a = nums[i];

            for (int j = nums.length - 1; j >= 0; j--) {
                while (j < nums.length - 1 && j > 0 && nums[j] == nums[j+1]) j--; 
                int d = nums[j];
                
                int p = i + 1;
                int q = j - 1;
                while (p < q) {
                    int b = nums[p];
                    int c = nums[q];
                    int sum = a + b + c + d;
                    if (sum == target) {
                        result.add(List.of(a, b, c, d));
                        p++;
                        while(p < j && nums[p] == nums[p-1]) p++; 
                        q--;
                        while(i < q && nums[q] == nums[q+1]) q--; 
                    }
                    else if (sum < target) { 
                        p++;
                    } else { 
                        q--;
                    }
                }
            }
        }
        return result;
    }
}