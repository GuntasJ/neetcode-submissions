class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) { break; }
            if (i > 0 && nums[i] == nums[i - 1]) { continue; }

            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == 0) {
                    triplets.add(List.of(nums[i], nums[low], nums[high]));
                    high--;
                    low++;
                    while (low < high && nums[low] == nums[low - 1]) {
                        low++;
                    }
                } else if (sum < 0) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return triplets;
    }
}
