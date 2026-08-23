class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> seenCharPositions = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            if (seenCharPositions.containsKey(s.charAt(right))) {
                left = Math.max(seenCharPositions.get(s.charAt(right)) + 1, left);
            } 
            seenCharPositions.put(s.charAt(right), right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
