class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int[] result = new int[nums.length - k + 1];
        int i = 0;
        int l = 0;
        for (int j = 0; j < k; j++) {
            queue.offer(nums[j]);
        }
        for (int r = k; r < nums.length + 1; r++) {
            result[i] = queue.peek();
            queue.remove(nums[l]);
            i++;
            l++;
            if (r < nums.length) {
                queue.offer(nums[r]);
            }
        }
        return result;
    }
}
