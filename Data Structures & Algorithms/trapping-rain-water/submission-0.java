class Solution {
    public int trap(int[] height) {
        int[] leftWalls = new int[height.length];
        int[] rightWalls = new int[height.length];
        int[] waterLevelBetween = new int[height.length];

        int max = 0;
        for (int i = 1; i < height.length; i++) {
            leftWalls[i] = Math.max(max, height[i - 1]);
            max = leftWalls[i];
        }
        max = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            rightWalls[i] = Math.max(max, height[i + 1]);
            max = rightWalls[i];
        }

        for (int i = 0; i < height.length; i++) {
            waterLevelBetween[i] = Math.min(leftWalls[i], rightWalls[i]);
        }

        int result = 0;
        for (int i = 0; i < height.length; i++) {
            result += Math.max(waterLevelBetween[i] - height[i], 0);
        }
        return result;
    }
}
