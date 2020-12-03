class Solution {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
            int min = Math.min(height[left], height[right]);
            int capacity = min * (right - left);
            max = Math.max(max, capacity);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}