class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;

        while (left < right) {
            int dx = right - left;
            maxArea = Math.max(maxArea, dx * Math.min(heights[left], heights[right]));
            if (heights[left] < heights[right]) {
                left++;
            }
            else if (heights[left] > heights[right]) {
                right--;
            }
            else {
                left++;
                right--;
            }
        }
        return maxArea;
    }
}
