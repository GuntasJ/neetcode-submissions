class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> characterFrequencies = new HashMap<>();
        int left = 0;
        int maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            characterFrequencies.merge(s.charAt(right), 1, (oldV, newV) -> oldV + 1);

            while (!isWindowValid(characterFrequencies, k, left, right)) {
                characterFrequencies.computeIfPresent(s.charAt(left), (key, v) -> v - 1);
                left++;
            }
            maxLength = Math.max(right - left + 1, maxLength);
        }
        return maxLength;
    }

    private boolean isWindowValid(Map<Character, Integer> cF, int k, int l, int r) {
        int maxF = 0;
        for (var entry : cF.values()) {
            maxF = Math.max(maxF, entry);
        }
        return (r - l + 1) - maxF <= k;
    }
}
