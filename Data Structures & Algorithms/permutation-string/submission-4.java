class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) { return false; }

        for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
            Map<Character, Integer> chars = new HashMap<>();
            for (char c : s1.toCharArray()) {
                chars.merge(c, 1, (a, b) -> a + 1);
            }
            for (int j = i; j < i + s1.length(); j++) {
                if (!chars.containsKey(s2.charAt(j))) {
                    break;
                }
                chars.computeIfPresent(s2.charAt(j), (k, v) -> v == 1 ? null : v - 1);
            }
            if (chars.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
