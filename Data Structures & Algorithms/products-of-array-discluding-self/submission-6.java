class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }
        int postFix = 1;
        for (int i = n - 2; i >= 0; i--) {
            result[i] = result[i] * nums[i + 1] * postFix;
            postFix *= nums[i + 1];
        }
        return result;
    }
}  
