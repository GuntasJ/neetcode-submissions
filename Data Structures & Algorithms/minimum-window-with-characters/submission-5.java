class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) { return ""; }
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        String bestString = "";

        int left = 0;
        int targetMatches = t.length();
        int matches = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (tMap.containsKey(c)) {
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);
                if (sMap.get(c) <= tMap.get(c)) {
                    matches++;
                }
            }
            while (matches == targetMatches) {
                if (bestString.isEmpty() || right - left + 1 < bestString.length()) {
                    bestString = s.substring(left, right + 1);
                }

                char cLeft = s.charAt(left);

                if (tMap.containsKey(cLeft)) {
                    if (sMap.get(cLeft) <= tMap.get(cLeft)) {
                        matches--;
                    }
                    sMap.put(cLeft, sMap.get(cLeft) - 1);
                }
                left++;
            }
        }    
        return bestString;
    }
}
