class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroCount = 0;
        for (int n : nums) {
            if (n == 0) {
                zeroCount++;
            } else {
                product *= n;
            }
        }
        
        if (zeroCount > 1) {
            return new int[nums.length];
        }
        if (zeroCount == 1) {
            int[] result = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    result[i] = product;
                    return result;
                } 
            }
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = product / nums[i];
        }
        return result;
    }
}  
