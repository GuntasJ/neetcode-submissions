class Solution {
    public int trap(int[] height) {
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int left = 1;
        int right = height.length - 2;

        int result = 0;
        while (left <= right) {
            if (leftMax <= rightMax) {
                result += Math.max(0, leftMax - height[left]);
                left++;
                leftMax = Math.max(leftMax, height[left - 1]);
            }
            else {
                result += Math.max(0, rightMax - height[right]);
                right--;
                rightMax = Math.max(rightMax, height[right + 1]);
            }
        }
        return result;
    }
}
