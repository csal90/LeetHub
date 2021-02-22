class Solution {
    public int maxArea(int[] height) {
        int low = 0;
        int high = height.length - 1;
        int maxArea = 0;
        
        while (low <= high) {
            int minLine = Math.min(height[low], height[high]);
            maxArea = Math.max(maxArea, minLine * (high - low));
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }
        
        return maxArea;
    }
}