class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) { return 0; }

        int maxLength = 1;
        int left = 0;
        int right = 1;
        Set<Character> seenChars = new HashSet<>();
        seenChars.add(s.charAt(0));

        while (right < s.length()) {
            if (seenChars.contains(s.charAt(right))) {
                while (left < right && seenChars.contains(s.charAt(right))) {
                    seenChars.remove(s.charAt(left));
                    left++;
                }
                seenChars.add(s.charAt(right));
            }
            else {
                seenChars.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
            }
            
            right++;
        }
        return maxLength;
    }
}
