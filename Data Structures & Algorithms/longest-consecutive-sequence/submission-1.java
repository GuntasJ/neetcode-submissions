class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (var num : nums) {
            numSet.add(num);
        }
        var longest = 0;
        for (var entry : numSet) {
            if (numSet.contains(entry - 1)) {
                continue;
            }
            int length = 1;
            while (numSet.contains(entry + length)) {
                length++;
            }
            longest = Math.max(longest, length);
        }
        return longest;
    }
}
